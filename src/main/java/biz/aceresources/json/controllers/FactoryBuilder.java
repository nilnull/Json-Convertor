package biz.aceresources.json.controllers;

import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.models.InputClass;
import biz.aceresources.json.models.OutputClass;
import biz.aceresources.json.parameters.SupportedFilesType;
import lombok.Builder;

/**
 * To convert the input file to output file
 * Process is read , convert and write
 */
@Builder
public class FactoryBuilder {
    /**
     * The Input file type.
     */
    SupportedFilesType inputFileType;
    /**
     * The Output file type.
     */
    SupportedFilesType outputFileType;
    /**
     * The Input params.
     */
    Object inputParams;
    /**
     * The Output params.
     */
    Object outputParams;

    /**
     * Convert.
     */
    public void convert() {
        ConversionFactory builder = ConversionFactory.builder().inputFileType(inputFileType).outputFileType(outputFileType).build();
        ApplicationConfiguration.getInstance().showDebug("The factory is starting its work");
        InputClass inputClass = builder.getReader().initiate(inputParams).read();
        ApplicationConfiguration.getInstance().showDebug(String.format("Reading %s as %s", inputParams, inputFileType.name()));
        OutputClass outputClass = builder.getConvertor().initiate(inputClass).Convert().getOutputClass();
        ApplicationConfiguration.getInstance().showDebug(String.format("Converting to desirable output (%s)", outputClass.getClass().toString()));
        ApplicationConfiguration.getInstance().showDebug("Writing file to  (" + outputParams + ")");
        builder.getWriter().initiate(outputParams).write(outputClass);

    }

}
