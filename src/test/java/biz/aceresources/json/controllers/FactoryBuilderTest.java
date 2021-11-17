package biz.aceresources.json.controllers;

import biz.aceresources.json.App;
import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.controllers.readers.JsonReader;
import biz.aceresources.json.models.InputClass;
import biz.aceresources.json.models.OutputClass;
import biz.aceresources.json.parameters.SupportedFilesType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class FactoryBuilderTest {

    public static final String SAMPLE_JSON = "Sample.json";
    public static final File INPUT_PARAMS = new File(SAMPLE_JSON);
    public static final File OUTPUT_CSV = new File("test/results/test.csv");
    public static final String PATH_TEST_TXT = "test/results/test.txt";
    public static final File OUTPUT_PARAMS = new File(PATH_TEST_TXT);
    public static final File OUTPUT_PDF = new File("test/results/test.pdf");


    @Test
    void producer() {
        FactoryBuilder.builder().inputParams(INPUT_PARAMS).inputFileType(SupportedFilesType.JSON)
                .outputFileType(SupportedFilesType.CSV).outputParams(OUTPUT_PARAMS).build().convert();
        assertFalse(!OUTPUT_PARAMS.exists());

    }

    @Test
    void application(){
        String[] arg = {SAMPLE_JSON, PATH_TEST_TXT, "-p"};

        App.main(arg);
    }

    @Test
    @DisplayName("Test builder")
    void builder() {
        ConversionFactory builder = ConversionFactory.builder().inputFileType(SupportedFilesType.JSON).outputFileType(SupportedFilesType.TXT).build();
        ApplicationConfiguration.getInstance().showDebug("The factory is starting its work");
        JsonReader reader = builder.getReader();
        reader.initiate(INPUT_PARAMS);
        InputClass inputClass = reader.read();
        assertNotNull(inputClass);
        OutputClass outputClass = builder.getConvertor().initiate(inputClass).convert().getOutputClass();
        assertNotNull(outputClass);
        builder.getWriter().initiate(OUTPUT_PARAMS).write(outputClass);
        assertFalse(!OUTPUT_PARAMS.exists());

    }

    @Test
    @DisplayName("Test builder")
    void testPdf() {
        ConversionFactory builder = ConversionFactory.builder().inputFileType(SupportedFilesType.JSON).outputFileType(SupportedFilesType.PDF).build();
        ApplicationConfiguration.getInstance().showDebug("The factory is starting its work");
        JsonReader reader = builder.getReader();
        reader.initiate(INPUT_PARAMS);
        InputClass inputClass = reader.read();
        assertNotNull(inputClass);
        OutputClass outputClass = builder.getConvertor().initiate(inputClass).convert().getOutputClass();
        assertNotNull(outputClass);
        builder.getWriter().initiate(OUTPUT_PDF).write(outputClass);
        assertFalse(!OUTPUT_PDF.exists());

    }
}