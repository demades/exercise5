package lu.uni.exercises.jakarta.xml.xmlComponents;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;

public class Cells
{
	@XmlElement(name="C")
    private C[] C;

    public C[] getC ()
    {
        return C;
    }

    public void setC (C[] C)
    {
        this.C = C;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [C = "+C+"]";
    }
}