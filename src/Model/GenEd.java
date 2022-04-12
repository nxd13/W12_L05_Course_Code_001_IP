package Model;

import java.util.ArrayList;

public class GenEd implements TableMember
{

    private String code;
    private String description;

    public GenEd()
    {
    }

    public GenEd(String a, String b)
    {
        description = a;
        code = b;
    }

    public String getInfo()
    {
        return "genEd{" + "description=" + getDescription() + ", code=" + getCode() + "}";
    }

    @Override
    public String toString()
    {
        return getCode();
    }

    /**
     * @return the code
     */
    public String getCode()
    {
        return code;
    }

    /**
     * @param Code the code to set
     */
    public void setCode(String Code)
    {
        this.code = Code;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param Description the description to set
     */
    public void setDescription(String Description)
    {
        this.description = Description;
    }

    @Override
    public String getAttribute(int n) {
        if (n == 0)
            return code;
        else
            return description;
    }

    @Override
    public ArrayList<String> getAttributes() {
        ArrayList<String> attributes = new ArrayList<String>();
        for (int i = 0; i < 2; i++)
            attributes.add(getAttribute(i));
        return attributes;
    }

    @Override
    public String getAttributeName(int n) {
        if (n == 0)
            return "Code";
        else
            return "Description";
    }

    @Override
    public ArrayList<String> getAttributesNames() {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < 2; i++)
            names.add(getAttributeName(i));
        return names;    }

}
