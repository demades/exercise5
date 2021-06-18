package lu.uni.exercises.jakarta.xml.xmlComponents;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;


public class Rows
{
	@XmlElement(name="Row")
    private Row[] Row;

    public Row[] getRow ()
    {
        return Row;
    }

    public void setRow (Row[] Row)
    {
        this.Row = Row;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Row = "+Row+"]";
    }
}
