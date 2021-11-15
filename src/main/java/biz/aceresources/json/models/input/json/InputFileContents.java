package biz.aceresources.json.models.input.json;

import biz.aceresources.json.models.InputClass;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;


/**
 * The type Input file contents.
 */
@Data
@EqualsAndHashCode
public class InputFileContents implements Serializable, InputClass {

    private final static long serialVersionUID = 2022423036240441649L;
    @SerializedName("items")
    @Expose
    @Getter
    private PojoItems pojoItems;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(InputFileContents.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("pojoItems");
        sb.append('=');
        sb.append(((this.pojoItems == null) ? "<null>" : this.pojoItems));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


}
