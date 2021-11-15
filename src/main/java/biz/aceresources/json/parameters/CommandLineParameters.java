package biz.aceresources.json.parameters;

import lombok.Getter;
import picocli.CommandLine;

import java.io.File;

/**
 * The type Command line parameters.
 * Values passed from CLI
 */
public class CommandLineParameters {
    /**
     * The Input file.
     */
    @Getter
    @CommandLine.Parameters(index = "0", description = "The input file address")
    File inputFile;
    /**
     * The Output file.
     */
    @Getter
    @CommandLine.Parameters(index = "1", description = "File address for the output file. Conversion results will be saved there")
    File outputFile;
    /**
     * The Show output.
     */
    @Getter
    @CommandLine.Option(names = {"-p", "--print"}, description = "Show output in terminal", defaultValue = "False")
    boolean showOutput = false;
    /**
     * The Append.
     */
    @Getter
    @CommandLine.Option(names = {"-A", "--append"}, description = "if true, then bytes will be written to the end of " +
            "the file rather than the beginning", defaultValue = "False")
    boolean append = false;

    /**
     * The Silence.
     */
    @Getter
    @CommandLine.Option(names = {"-s", "--silence"}, description = "Hide debugging information")
    boolean silence = false;

    /**
     * The Input type.
     */
    @Getter
    @CommandLine.Option(names = {"-i", "--input"}, defaultValue = "JSON", paramLabel = "INPUT_FORMAT", description = "Optionally specify the input format (${COMPLETION-CANDIDATES}).\n" +
            "'If omitted the default type is used.' , Currently only JSON is supported")
    SupportedFilesType inputType = SupportedFilesType.JSON;


    /**
     * The Output type.
     */
    @Getter
    @CommandLine.Option(names = {"-o", "--output"}, defaultValue = "TXT", paramLabel = "OUTPUT_FORMAT", description = "Optionally specify the output format (${COMPLETION-CANDIDATES}).\n" +
            "'If omitted the default type is used.' , Currently TXT and CSV are supported")
    SupportedFilesType outputFilesType = SupportedFilesType.TXT;


    /**
     * The Version requested.
     */
    @CommandLine.Option(names = {"-V", "--version"}, versionHelp = true,
            description = "print version information and exit")
    boolean versionRequested;

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
    private boolean helpRequested;


}