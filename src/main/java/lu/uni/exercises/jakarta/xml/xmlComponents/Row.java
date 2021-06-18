package lu.uni.exercises.jakarta.xml.xmlComponents;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;


public class Row
{
	@XmlElement(name="RowLabels")
    private RowLabels RowLabels;

	@XmlElement(name="Cells")
    private Cells Cells;

    public RowLabels getRowLabels ()
    {
        return RowLabels;
    }

    public void setRowLabels (RowLabels RowLabels)
    {
        this.RowLabels = RowLabels;
    }

    public Cells getCells ()
    {
        return Cells;
    }

    public void setCells (Cells Cells)
    {
        this.Cells = Cells;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [RowLabels = "+RowLabels+", Cells = "+Cells+"]";
    }
}
