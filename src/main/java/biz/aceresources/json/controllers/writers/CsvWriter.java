package biz.aceresources.json.controllers.writers;

import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.models.output.OutputTable;
import biz.aceresources.json.utils.CSVUtil;

import java.util.logging.Logger;

public class CsvWriter extends OutputWriter<OutputTable> {
    private static final Logger LOGGER = Logger.getLogger(CsvWriter.class.getSimpleName());

    @Override
    public void write(OutputTable data) {
        String csvTable = CSVUtil.toCSV(data.getItems(), ',', true);
        showDebug(csvTable);
        writeFile(csvTable);
    }
    void showDebug(String s ) {
        if (ApplicationConfiguration.getInstance().isDebug())
            LOGGER.info(s);
    }
}
