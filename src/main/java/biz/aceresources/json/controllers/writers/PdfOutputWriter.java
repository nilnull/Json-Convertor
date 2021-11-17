package biz.aceresources.json.controllers.writers;

import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.models.output.DesiredObjectsHolder;
import biz.aceresources.json.utils.PdfUtil;

import java.io.File;
import java.util.logging.Logger;

/**
 * To create pdf from an object
 */
public class PdfOutputWriter extends OutputWriter<DesiredObjectsHolder> {


    private static final Logger LOGGER = Logger.getLogger(PdfOutputWriter.class.getSimpleName());

    /**
     * Write object as a pdf file
     * @param data the value to be written
     */
    @Override
    public void write(DesiredObjectsHolder data) {
        File file = (File) param;
        file.getParentFile().mkdirs();
        if (ApplicationConfiguration.getInstance().isDebug())
            LOGGER.info("Writing PDF to " + file.getAbsolutePath());
        new PdfUtil().toPdf(data.getItems(), file, true);
    }

}
