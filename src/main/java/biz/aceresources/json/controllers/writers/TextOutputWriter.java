package biz.aceresources.json.controllers.writers;

import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.errors.AceApplicationException;
import biz.aceresources.json.models.output.DesiredObjectsHolder;
import biz.aceresources.json.utils.StringUtils;
import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.HorizontalAlign;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


/**
 * To write output as a file
 */
public class TextOutputWriter extends OutputWriter<DesiredObjectsHolder> {
    private static final Logger LOGGER = Logger.getLogger(TextOutputWriter.class.getSimpleName());


    /**
     * To write the array to file based on provided address as an ascii table
     *
     * @param data Value to write
     */
    public void write(DesiredObjectsHolder data) {
       if  (! data.getItems().isEmpty()){
            //Get properties of first object in list
            Field[] fields = data.getItems().get(0).getClass().getDeclaredFields();
            showDebug("Creating header for table ");
            List columns = createHeadersList(fields);
            Optional.of(data).ifPresent(outputTable -> {
                String table = AsciiTable.getTable(AsciiTable.BASIC_ASCII, data.getItems(), columns);
                showDebug(table);
                writeFile(table);
            });
        }
    }

    /**
     * Create header low
     * @param fields list of object properties
     * @return list of columns
     */
    private List<Column> createHeadersList(Field[] fields) {
        List columns = new ArrayList<>();
        for (Field field : fields) {
            columns.add(buildField(field));
        }
        return columns;
    }


    /**
     * Create a column for a field (property name) of an object. field name will be header and value will be fetched from that name
     *
     * @param field field to add
     * @return produced column
     */
    private Column buildField(Field field) {
        String value;
        try {
            value = field.getName();
            return new Column().dataAlign(HorizontalAlign.LEFT).header(StringUtils.capitalizeFirstLetter(value)).with(o -> {
                field.setAccessible(true);
                try {
                    return StringUtils.getValue(field.get(o));
                } catch (IllegalAccessException e) {
                    throw new AceApplicationException(e);
                }
            });
        } catch (IllegalArgumentException e) {
            throw new AceApplicationException(e);
        }
    }
    void showDebug(String s ) {
        if (ApplicationConfiguration.getInstance().isDebug())
            LOGGER.info(s);
    }
}



