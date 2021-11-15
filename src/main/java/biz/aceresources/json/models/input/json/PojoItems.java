package biz.aceresources.json.models.input.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


/**
 * The type Pojo items.
 */
@Data
@ToString
@EqualsAndHashCode
public class PojoItems implements Serializable {

    private final static long serialVersionUID = -2496298808231368300L;
    @SerializedName("item")
    @Expose
    private List<Item> item = null;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("item");
        sb.append('=');
        sb.append(((this.item == null) ? "<null>" : this.item));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


}
