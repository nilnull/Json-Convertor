package biz.aceresources.json.controllers.writers;

import biz.aceresources.json.config.ApplicationConfiguration;
import biz.aceresources.json.errors.AceApplicationException;
import biz.aceresources.json.models.output.OutputTable;
import biz.aceresources.json.models.output.OutputTableItem;
import biz.aceresources.json.utils.StringUtils;
import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.HorizontalAlign;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


/**
 * To write output as a file
 */
public class TextTableFileWriter extends OutputWriter<OutputTable> {


    /**
     * To write the array to file based on provided address as an ascii table
     *
     * @param data Value to write
     */
    public void write(OutputTable data) {

        Field[] fields = data.getItems().get(0).getClass().getDeclaredFields();
        List columns =  new ArrayList<>();
        for (Field field : fields) {
          columns.add(buildField(field));
        }
        Optional.of(data).ifPresent(outputTable -> {
            String table = AsciiTable.getTable(AsciiTable.BASIC_ASCII, data.getItems(), columns);
            print(table);
            writeFile(table);

        });
    }


    /**
     * Create a column for a field of an object. field name will be header and value will be fetched from that name
     * @param field field to add
     * @return column
     */
    private Column buildField(Field field) {
        field.setAccessible(true);
        String value;
        try {
            value = field.getName();
            return new Column().dataAlign(HorizontalAlign.LEFT).header(StringUtils.capitalizeFirstLetter(value)).with(new Function<Object, String>() {
                @Override
                public String apply(Object o) {
                    field.setAccessible(true);
                    try {
                       return StringUtils.getValue(field.get(o));
                    } catch (IllegalAccessException e) {
                        throw new AceApplicationException(e);
                    }
                }
            });
        } catch (IllegalArgumentException e) {
            throw new AceApplicationException(e);
        }
    }
}



