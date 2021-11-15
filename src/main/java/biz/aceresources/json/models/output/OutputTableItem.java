package biz.aceresources.json.models.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * The type Output table item.
 */
@Getter
@Setter
@Builder
/**
 * This is a row of data that will be printed in table
 */
public class OutputTableItem implements Serializable {
    /**
     * The Id.
     */
    String id;
    /**
     * The Type.
     */
    String type;
    /**
     * The Name.
     */
    String name;
    /**
     * The Batter.
     */
    String batter;
    /**
     * The Topping.
     */
    String topping;


    /**
     * This is used for text output of each row (lazy approach)
     *
     * @returns a text containing values of the row
     */
    @Override
    public String toString() {
        return "|" + id + "\t" +
                "| " + type + '\t' +
                "| " + name + '\t' +
                "| " + batter + '\t' +
                "| " + topping + '\t';
    }
}
