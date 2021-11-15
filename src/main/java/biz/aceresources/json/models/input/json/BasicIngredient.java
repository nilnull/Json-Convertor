package biz.aceresources.json.models.input.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * Common items in ingredients
 */
@Data
@ToString
@EqualsAndHashCode
public class BasicIngredient implements Serializable {

    private final static long serialVersionUID = -3867005697506723011L;
    /**
     * The Id.
     */
    @SerializedName("id")
    @Expose
    String id;
    /**
     * The Type.
     */
    @SerializedName("type")
    @Expose
    String type;
}
