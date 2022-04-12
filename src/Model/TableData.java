package Model;

import java.util.ArrayList;

/**
* The TableData interface enables a Data class to be used in a Table Display application. 
 * It has methods to deal with tables of data of a single class.
 * It expects the data to be stored is a data ArraList
 *
 * @author IST242
 */
public interface TableData
{

    /**
     * it should be called in the constructor and loads the objects of a specific 
     * class into an ArrayList
     */
    public void loadTable();

    /**
     * @return returns the basic arrayList containing all objects of a class
     */
    public ArrayList getTable();

    /**
     *setSelectedFields receives an array which contains a list of selected attributes.
     * 
     * @param selected represents the an int[] array with the index positions 
     * of selected attributes
     * 0 is the first attribute
     */
    public void setSelectedFields(int[] selected);

    /**
     *
     * @return an int[] array with the index positions of selected attributes
     */
    public int[] getSelectedFields();

    /**
     *
     * @return an ArrayList of Strings with the attribute names of a class that implements this interface.
     */
    public ArrayList<String> getHeaders();

    /**
     *getLine returns an ArrayList of Strings with all the attribute values of an object in the data ArrayList
     * @param line represents the object position in the data ArrayList
     * @return
     */
    public ArrayList<String> getLine(int line);

    /**
     *getLines return a list of lines defined by a range.
     * It uses getLine(int line) method.
     * @param firstLine is the first line of a range to be returned
     * @param lastLine is the last line of a range to be returned
     * @return an ArrayList of ArrayLists with Strings
     */
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine);

}
