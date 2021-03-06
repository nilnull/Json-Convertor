package biz.aceresources.json;

import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.controllers.FactoryBuilder;
import biz.aceresources.json.errors.AceApplicationException;
import biz.aceresources.json.parameters.CommandLineParameters;
import picocli.CommandLine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/**
 * Main class of application
 */
public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getSimpleName());

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {


        // Fetch application parameters
        CommandLineParameters appParams = parseParameters(args);

        //Show ACE LOGO
        showLogo();
        if (appParams == null || appParams.getInputFile() == null || appParams.getOutputFile() == null) return;
        try {

            //Do the conversion
            FactoryBuilder.builder().inputParams(appParams.getInputFile()).inputFileType(appParams.getInputType())
                    .outputFileType(appParams.getOutputFilesType()).outputParams(appParams.getOutputFile()).build().convert();


        } catch (AceApplicationException err) {
            if (!ApplicationConfiguration.getInstance().isDebug()) {
                // Suggest user to disable silence
                System.out.println("Debug is disabled you can show more info by removing -s from parameters");
            }

            System.err.print(err.getShortMessage());
            showDebug(err.getMessage());
        }
    }

     static void showDebug(String s ) {
        if (ApplicationConfiguration.getInstance().isDebug())
            LOGGER.info(s);
    }

    /**
     * Get application parameters and parse them
     *
     * @param args arguments passed throw command line
     * @return CommandLineParameters parameters
     */
    private static CommandLineParameters parseParameters(String[] args) {
        CommandLineParameters commandLineParameters = new CommandLineParameters();
        CommandLine commandLine = new CommandLine(commandLineParameters);
        commandLine.parseArgs(args);
        if (commandLine.isUsageHelpRequested()) {
            commandLine.usage(System.out);
            return null;
        } else if (commandLine.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
            return null;
        }

        //If we have the silence parameter should not show debug info
        ApplicationConfiguration.getInstance().setDebug(!commandLineParameters.isSilence());

        // To print the output on monitor
        ApplicationConfiguration.getInstance().setPrintOutput(commandLineParameters.isShowOutput());

        // if true instead of overriding the file, application will append to existing file
        ApplicationConfiguration.getInstance().setAppend(commandLineParameters.isAppend());
        return commandLineParameters;
    }


    /**
     * Fun to show logo
     */
    private static void showLogo(){
        if (ApplicationConfiguration.getInstance().isDebug()) {
            BufferedReader in;
            try {
                in = new BufferedReader(new FileReader("logo.ans"));

                String line;

                line = in.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = in.readLine();
                }
                in.close();
                TimeUnit.SECONDS.sleep(5);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                //We don't care if logo is not shown'//   e.printStackTrace();
            }
        }
    }
}
