package biz.aceresources.json.models.output;

import biz.aceresources.json.models.OutputClass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * The type Output table.
 */
@Data
@ToString
@Setter
@Getter
public class OutputTable implements OutputClass {

    /**
     * The Items.
     */
    List<OutputTableItem> items;

}
