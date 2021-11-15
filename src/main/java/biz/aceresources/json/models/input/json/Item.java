package biz.aceresources.json.models.input.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * The type Item.
 */
@Data
@ToString
@EqualsAndHashCode
public class Item extends BasicIngredient implements Serializable {

    private final static long serialVersionUID = -7419284797220207873L;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ppu")
    @Expose
    private Double ppu;
    @SerializedName("batters")
    @Expose
    private Batters batters;
    @SerializedName("topping")
    @Expose
    private List<Topping> topping = null;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("ppu");
        sb.append('=');
        sb.append(((this.ppu == null) ? "<null>" : this.ppu));
        sb.append(',');
        sb.append("batters");
        sb.append('=');
        sb.append(((this.batters == null) ? "<null>" : this.batters));
        sb.append(',');
        sb.append("topping");
        sb.append('=');
        sb.append(((this.topping == null) ? "<null>" : this.topping));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
