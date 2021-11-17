package biz.aceresources.json.controllers.writers;

import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.models.output.OutputTable;
import biz.aceresources.json.utils.PdfUtil;

import java.io.File;
import java.util.logging.Logger;

public class PdfOutputWriter extends OutputWriter<OutputTable> {


    private static final Logger LOGGER = Logger.getLogger(PdfOutputWriter.class.getSimpleName());

    @Override
    public void write(OutputTable data) {
        File file = (File) param;
        file.getParentFile().mkdirs();
        if (ApplicationConfiguration.getInstance().isDebug())
            LOGGER.info("Writing PDF to " + file.getAbsolutePath());
        new PdfUtil().toPdf(data.getItems(), file, true);
    }

}
