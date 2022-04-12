package Model;

import java.util.ArrayList;

public class Course implements TableMember
{

    private CourseName name;
    private ArrayList<GenEd> genEds;
    private String description;
    private Integer credits;
    private String preReqs;
    private String comments;

    public Course()
    {

    }

    public Course(String a, String b, String c, String d, int e, String f, String g)
    {
        name = new CourseName(a, b, c);
        genEds = new ArrayList<>();
        description = d;
        credits = e;
        preReqs = f;
        comments = g;
    }

    public Course(String a, String b, String c)
    {
        name = new CourseName(a, b, c);
        genEds = new ArrayList<>();
        description = "";
        credits = 0;
        preReqs = "";
        comments = "";
    }

    /**
     * @return the name
     */
    public CourseName getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(CourseName name)
    {
        this.name = name;
    }

    /**
     * @return the genEds
     */
    public ArrayList<GenEd> getGenEds()
    {
        return genEds;
    }

    /**
     * @param genEds the genEds to set
     */
    public void setGenEds(ArrayList<GenEd> genEds)
    {
        this.genEds = genEds;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the credits
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(int credits)
    {
        this.credits = credits;
    }

    /**
     * @return the preReqs
     */
    public String getPreReqs()
    {
        return preReqs;
    }

    /**
     * @param preReqs the preReqs to set
     */
    public void setPreReqs(String preReqs)
    {
        this.preReqs = preReqs;
    }

    /**
     * @return the comments
     */
    public String getComments()
    {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments)
    {
        this.comments = comments;
    }

    @Override
    public String getAttribute(int n) {
        String result = "";
        switch(n) { 
            case 0: result = name.getCourseNameFormatted(); break;
            case 1: result = genEds.toString(); break;
            case 2: result = description; break;
            case 3: result = credits.toString(); break;
            case 4: result = preReqs; break;
            case 5: result = comments; break;
        }
        return result;
    }

    @Override
    public ArrayList<String> getAttributes() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 6; i++) {
            list.add(getAttribute(i));
        }
        return list;
    }

    @Override
    public String getAttributeName(int n) {
        String result = "";
        switch(n) { 
            case 0: result = "Name"; break;
            case 1: result = "GenEds"; break;
            case 2: result = "Description"; break;
            case 3: result = "Credits"; break;
            case 4: result = "PreReqs"; break;
            case 5: result = "Comments"; break;
        }
        return result;
    }

    @Override
    public ArrayList<String> getAttributesNames() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 6; i++) {
            list.add(getAttributeName(i));
        }
        return list;
    }

}
