package biz.aceresources.json.controllers.writers;

import biz.aceresources.json.models.output.OutputTable;
import biz.aceresources.json.utils.CSVUtil;

public class CsvWriter extends OutputWriter<OutputTable> {
    @Override
    public void write(OutputTable data) {
        String csvTable = CSVUtil.toCSV(data.getItems(), ',', true);
        print(csvTable);
        writeFile(csvTable);
    }
}
