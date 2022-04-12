package Model;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CourseData implements TableData, Displayable, Sortable {

    private ArrayList<Course> courses;
    private int[] selectedFields;
    // Instance variables needed for Displayable
    private int firstLineToDisplay;
    private int lastLineToDisplay;
    private int lineToHighlight;
    private int getLinesBeingDisplayed;
    // Instance variables needed for Sortable
    private int sortType;
    private int sortField;
    private Comparator<Course> field;

    public CourseData() {
        courses = new ArrayList<>();
        loadTable();
    }

    public void ReadCoursesFromXML() {
        try {
            Course cs;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("CourseTable.xml")));
            cs = new Course();
            while (cs != null) {
                try {
                    cs = (Course) decoder.readObject();
                    courses.add(cs);

                } catch (ArrayIndexOutOfBoundsException theend) {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx) {
            xx.printStackTrace();
        }
    }

    @Override
    public void loadTable() {
        ReadCoursesFromXML();
    }

    @Override
    public ArrayList getTable() {
        return courses;
    }

    @Override
    public void setSelectedFields(int[] selected) {
        if (selected.length != 0)
            selectedFields = selected;
        else {
            selectedFields = new int[6];
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
            headers.add(courses.get(0).getAttributeName(selectedFields[i]));
        }
        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
//        ArrayList<String> data = new ArrayList<String>();
//        for (int i = 0; i < selectedFields.length; i++) {
//            data.add(courses.get(line).getAttribute(selectedFields[i]));
//        }
//        return data;
        return courses.get(line).getAttributes();
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i < lastLine; i++) {
            lines.add(getLine(i));
        }
        return lines;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineToDisplay;
    }

    @Override
    public int getLineToHighlight() {
        return lineToHighlight;
    }

    @Override
    public int getLastLineToDisplay() {
        return lastLineToDisplay;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return getLinesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineToDisplay = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        lineToHighlight = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineToDisplay = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        getLinesBeingDisplayed = numberOfLines;
    }

    // Methods implemented for Sortable
    @Override
    public void sort(int sortType, int sortField) {
        //sortType: 1) selection, 2) merge, 3) quick
        // sortField: range 0 - 5 (fields for Course)
        setSortType(sortType);
        setSortField(sortField);
        System.out.println("Sort method: " + sortType + " " + sortField);
        switch (sortType) {
            case 1: // selection sort -- written in class
                selectionSort();
                break;
            case 2: // merge sort -- Use Collections class
                Collections.sort(courses, field);
                break;
            case 3: // quick sort -- Use Arrays class
                Course[] array = copyList(courses); // create array copy
                Arrays.sort(array, field); // sort array
                courses = new ArrayList<Course>(Arrays.asList(array));
                break;
        }

    }

    private Course[] copyList(ArrayList<Course> data) {
        Course[] array = new Course[data.size()];
        for (int i = 0; i < data.size(); i++)
            array[i] = data.get(i);
        return array;
    }

    private void selectionSort() {
        for (int i = 0; i < courses.size(); i++) {
            // find minimum
            int minPos = minimumPosition(courses, i);
            // swap -- value in position i with value in position minPos
            swap(courses, minPos, i);
        }
    }

    private void swap(ArrayList<Course> a, int minPos, int i) {
        if (minPos != i) {
            Course temp = a.get(i);
            a.set(i, a.get(minPos));
            a.set(minPos, temp);
        }
    }

    private int minimumPosition(ArrayList<Course> a, int from) {
        int minPos = from;
        for (int i = from + 1; i < a.size(); i++) {
            if(a.get(i).getAttribute(sortField).compareTo(
                    a.get(minPos).getAttribute(sortField)) < 0) {
                minPos = i;
            }
        }
        return minPos;
    }

    @Override
    public int getSortType() {
        return sortType;
    }

    @Override
    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    @Override
    public int getSortField() {
        return sortField;
    }

    @Override
    public void setSortField(int sortField) {
        this.sortField = sortField;
        switch (sortField) {
            case 0:
                field = sortByName; break;
            case 1: // not using gen eds
                field = sortByName; break;
            case 2:
                field = sortByDescription; break;
            case 3:
                field = sortByCredits; break;
            case 4:
                field = sortByPreReqs; break;
            case 5:
                field = sortByComments;
        }
    }

    // define Comparators
    Comparator<Course> sortByName = new Comparator<Course>() {
        @Override
        public int compare(Course course, Course t1) {
            return course.getName().compareTo(t1.getName());
        }
    };
    Comparator<Course> sortByDescription = new Comparator<Course>() {
        @Override
        public int compare(Course course, Course t1) {
            return course.getDescription().compareTo(t1.getDescription());
        }
    };
    Comparator<Course> sortByCredits = new Comparator<Course>() {
        @Override
        public int compare(Course course, Course t1) {
            // compare here
            if (course.getCredits() < t1.getCredits()) return -1;
            if (course.getCredits() == t1.getCredits()) return 0;
            return 1;
        }
    };
    Comparator<Course> sortByPreReqs = new Comparator<Course>() {
        @Override
        public int compare(Course course, Course t1) {
            return course.getPreReqs().compareTo(t1.getPreReqs());
        }
    };
    Comparator<Course> sortByComments = new Comparator<Course>() {
        @Override
        public int compare(Course course, Course t1) {
            return course.getComments().compareTo(t1.getComments());
        }
    };
}
