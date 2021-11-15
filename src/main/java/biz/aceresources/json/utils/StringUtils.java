package biz.aceresources.json.utils;

/**
 * The type String utils.
 */
public class StringUtils {
    /**
     * Gets value.
     *
     * @param val the val
     * @return the value
     */
    public static String getValue(Object val) {
        if (val == null) {
            return "Not Defined";
        } else {
            return val.toString();
        }

    }
    public static String capitalizeFirstLetter(String name){
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
