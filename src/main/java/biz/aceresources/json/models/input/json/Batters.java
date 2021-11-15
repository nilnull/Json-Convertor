package biz.aceresources.json.models.input.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


/**
 * The type Batters.
 */
public class Batters implements Serializable {

    private final static long serialVersionUID = 4865657527777613398L;
    @SerializedName("batter")
    @Expose
    private List<Batter> batter = null;

    /**
     * Gets batter.
     *
     * @return the batter
     */
    public List<Batter> getBatter() {
        return batter;
    }

    /**
     * Sets batter.
     *
     * @param batter the batter
     */
    public void setBatter(List<Batter> batter) {
        this.batter = batter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("batter");
        sb.append('=');
        sb.append(((this.batter == null) ? "<null>" : this.batter));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.batter == null) ? 0 : this.batter.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Batters) == false) {
            return false;
        }
        Batters rhs = ((Batters) other);
        return ((this.batter == rhs.batter) || ((this.batter != null) && this.batter.equals(rhs.batter)));
    }

}
