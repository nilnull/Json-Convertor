package biz.aceresources.json.controllers;

import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.controllers.readers.InputReader;
import biz.aceresources.json.models.InputClass;
import biz.aceresources.json.models.OutputClass;
import biz.aceresources.json.parameters.SupportedFilesType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class FactoryBuilderTest {

    public static final File INPUT_PARAMS = new File("Sample.json");
    public static final File OUTPUT_PARAMS = new File("test.out");

    @Test
    void producer() {
        FactoryBuilder.builder().inputParams(INPUT_PARAMS).inputFileType(SupportedFilesType.JSON)
                .outputFileType(SupportedFilesType.CSV).outputParams(OUTPUT_PARAMS).build().convert();
        assertFalse(!OUTPUT_PARAMS.exists());

    }


    @Test
    @DisplayName("Test builder")
    void builder() {
        ConversionFactory builder = ConversionFactory.builder().inputFileType(SupportedFilesType.JSON).outputFileType(SupportedFilesType.TXT).build();
        ApplicationConfiguration.getInstance().showDebug("The factory is starting its work");
        InputReader reader = builder.getReader();
        reader.initiate(INPUT_PARAMS);
        InputClass inputClass = reader.read();
        assertNotNull(inputClass);
        OutputClass outputClass = builder.getConvertor().initiate(inputClass).Convert().getOutputClass();
        assertNotNull(outputClass);
        builder.getWriter().initiate(OUTPUT_PARAMS).write(outputClass);
        assertFalse(!OUTPUT_PARAMS.exists());

    }
}