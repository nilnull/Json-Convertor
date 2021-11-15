package biz.aceresources.json.controllers;

import biz.aceresources.json.controllers.readers.InputReader;
import biz.aceresources.json.controllers.readers.JsonFileReader;
import biz.aceresources.json.controllers.writers.CsvWriter;
import biz.aceresources.json.controllers.writers.OutputWriter;
import biz.aceresources.json.controllers.writers.TextTableFileWriter;
import biz.aceresources.json.parameters.ConversionType;
import biz.aceresources.json.parameters.SupportedFilesType;
import lombok.Builder;

/**
 * This classd is in charge of giving us reader, writer and convertors
 */
@Builder
public class ConversionFactory {
    /**
     * The Input file type.
     */
    SupportedFilesType inputFileType;
    /**
     * The Output file type.
     */
    SupportedFilesType outputFileType;
    /**
     * The Conversion type.
     */
    ConversionType conversionType;


    /**
     * Get reader based on input format
     *
     * @return reader
     */
    public InputReader getReader() {
        return new JsonFileReader();
        // Todo: Add readers for other formats
        /*
        switch (type) {
            case TXT:
                break;
            case JSON:
                return new JsonFileReader((File) params);
            case CSV:
                break;
            case PDF:
                break;
            case DOC:
                break;
        }
        return null;

         */
    }

    /**
     * get writer based on output format
     *
     * @return output writer
     */
    public OutputWriter getWriter() {
        // Todo : Add writers for other formats
        switch (outputFileType) {
            case TXT:
                return new TextTableFileWriter();
            case CSV:
                return new CsvWriter();

            case JSON:

            case PDF:

            case DOC:

        }
        return new TextTableFileWriter();

    }

    /**
     * Get the converter based on conversion type and in and out
     *
     * @return a convertor
     */
    public OutputConvertor getConvertor() {
        return new TableItemsMapper();
    }
}
