package Model;

import java.util.ArrayList;

public class Model
{
    private CourseData cd;
    private GenEdData gd;
    private ArrayList<ArrayList<String>> lines;

    public Model()
    {
        cd = new CourseData();
        gd = new GenEdData();
        // set data for displayable interface
        cd.setFirstLineToDisplay(0);
        cd.setLastLineToDisplay(20);
        cd.setLinesBeingDisplayed(20);
        // retrieve data for rows of data -- lines
        lines = cd.getLines(cd.getFirstLineToDisplay(), cd.getLastLineToDisplay());
    }

    public CourseData getCd() {
        return cd;
    }

    public GenEdData getGd() {
        return gd;
    }

    public ArrayList<ArrayList<String>> getLines() {
        lines = cd.getLines(cd.getFirstLineToDisplay(), cd.getLastLineToDisplay());
        return lines;
    }

    public String getGenEdInfo(int n) {
        String obj = gd.getLine(n).toString();
        return obj;
    }
    
    public String getCourseInfo(int n) {
        String obj = cd.getLine(n).toString();
        return obj;        
    }
}
