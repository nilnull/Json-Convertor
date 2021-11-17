package biz.aceresources.json.controllers;

import biz.aceresources.json.controllers.readers.JsonExampleFileReader;
import biz.aceresources.json.controllers.readers.JsonReader;
import biz.aceresources.json.controllers.writers.CsvWriter;
import biz.aceresources.json.controllers.writers.OutputWriter;
import biz.aceresources.json.controllers.writers.PdfOutputWriter;
import biz.aceresources.json.controllers.writers.TextWriter;
import biz.aceresources.json.parameters.ConversionType;
import biz.aceresources.json.parameters.SupportedFilesType;
import com.itextpdf.kernel.pdf.PdfWriter;
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
    public JsonReader getReader() {
        return new JsonExampleFileReader();
        // Todo: Add readers for other formats
        /*
        switch (type) {
            case TXT:
                break;
            case JSON:
                return new JsonExampleFileReader((File) params);
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
                return new TextWriter();
            case CSV:
                return new CsvWriter();

            case JSON:

            case PDF:
                return new PdfOutputWriter();
            case DOC:

        }
        return new TextWriter();

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
