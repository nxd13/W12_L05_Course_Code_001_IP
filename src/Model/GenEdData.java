package Model;

import java.util.ArrayList;

public class GenEdData implements TableData 
{

    private ArrayList<GenEd> genEds;
    private int[] selectedFields;

    public GenEdData()
    {
        genEds = new ArrayList<>();
        CreateGenEds();
    }

    public void CreateGenEds()
    {
        GenEd ge1 = new GenEd("Writing/Speaking", "GWS");
        GenEd ge2 = new GenEd("Quantification", "GQ");
        GenEd ge3 = new GenEd("Arts", "GA");
        GenEd ge4 = new GenEd("Humanities", "GH");
        GenEd ge5 = new GenEd("Health and Wellness", "GHW");
        GenEd ge6 = new GenEd("Natural Sciences", "GN");
        GenEd ge7 = new GenEd("Social and Behavioral Sciences", "GS");
        GenEd ge8 = new GenEd("United States Cultures", "US");
        GenEd ge9 = new GenEd("International Cultures", "IL");
        genEds.add(ge1);
        genEds.add(ge2);
        genEds.add(ge3);
        genEds.add(ge4);
        genEds.add(ge5);
        genEds.add(ge6);
        genEds.add(ge7);
        genEds.add(ge8);
        genEds.add(ge9);
    }

    @Override
    public void setSelectedFields(int[] selected) {
        if (selected.length != 0)
            selectedFields = selected;
        else {
            selectedFields = new int[2];
            for (int i = 0; i < selectedFields.length; i++) {
                selectedFields[i] = i;
            }
        }
    }

    @Override
    public int[] getSelectedFields() {
        return selectedFields;
    }

    @Override
    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        String result = "";
        for (int i = 0; i < selectedFields.length; i++) {
            headers.add(genEds.get(0).getAttributeName(selectedFields[i]));
        }
        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < selectedFields.length; i++) {
            data.add(genEds.get(line).getAttribute(selectedFields[i]));
        }
        return data;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            lines.add(getLine(i));
        }
        return lines;
    }

    @Override
    public void loadTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
