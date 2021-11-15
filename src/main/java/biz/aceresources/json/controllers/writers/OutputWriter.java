package biz.aceresources.json.controllers.writers;


import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.errors.AceApplicationException;
import biz.aceresources.json.models.OutputClass;

import java.io.*;

/**
 * This is to be implemented for diffrent types of output formats
 * for example TXT, CSV, PDF and etc
 *
 * @param <T> the type parameter
 */
public abstract class OutputWriter<T extends OutputClass> {

    /**
     * The Param.
     */
    protected Object param;

    /**
     * Initiate output class with parameter
     *
     * @param parameter the parameter
     * @return the output writer
     */
    public OutputWriter<T> initiate(Object parameter) {
        this.param = parameter;
        return this;
    }

    /**
     * To write the converted value
     *
     * @param data the value to be written
     */
    public abstract void write(T data);

    protected void writeFile(String data){
        try (FileOutputStream fos = new FileOutputStream((File) param, ApplicationConfiguration.getInstance().isAppend())) {// initiate file
            try (OutputStreamWriter bufferedWriter = new OutputStreamWriter(fos)) {
                    bufferedWriter.write(data);
                }
            } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            throw new AceApplicationException(e);
        }
    }
    protected void print(String table) {
        if (ApplicationConfiguration.getInstance().isPrintOutput()) {
            System.out.print(System.lineSeparator() + table + System.lineSeparator());
        }
    }
}
