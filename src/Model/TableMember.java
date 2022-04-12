package Model;

import java.util.ArrayList;

/**
 * The TableMember interface enables a class to be used in a Table Display application. 
 * It has methods to return one selected attribute name as a String
 * or all attributes names as an array of Strings.
 *
 * It also returns the value of one selected attribute as a String or the values
 * of all attributes as an array of Strings, one value in each String.
 *
 *
 * @author IST 242
 */
public interface TableMember
{

    /**
     *getAttribute returns the value of selected attribute of a class.
     *The attribute is returned as a String independently of its original type.
     * 
     * @param n represents the index of the selected attribute
     * 0 means the first attribute
     * 
     * @return a String with the value of the selected attribute.
     */
    public String getAttribute(int n);

    /**
     *getAttributes returns the value of all attributes of a class.
     *The attributes are returned as a String Array.
     * 
     * @return an array of string with the value of all attributes.
     */
    public ArrayList<String> getAttributes();

    /**
     *getAttributeName returns the name of selected attribute of a class
     *The attribute is returned as a String
     * 
     * @param n represents the index of the selected attribute
     * 0 means the first attribute
     * 
     * @return a String with the value of the name of the selected attribute
     */
    public String getAttributeName(int n);

    /**
     *getAttributesNames returns the value of all names of the attributes of a class.
     *The names of the attributes are returned as a String Array.
     * 
     * @return an array of string with the names of all attributes.
     */
    public ArrayList<String> getAttributesNames();
}
