package lu.uni.exercises.jakarta.xml.xmlComponents;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;


public class Data
{
    private String colspan;

    private String rowPos;

    private String d;

    private String rowspan;

    private String colPos;

    private String cols;

    @XmlElement(name="Rows")
    private Rows Rows;

    public String getColspan ()
    {
        return colspan;
    }

    public void setColspan (String colspan)
    {
        this.colspan = colspan;
    }

    public String getRowPos ()
    {
        return rowPos;
    }

    public void setRowPos (String rowPos)
    {
        this.rowPos = rowPos;
    }

    public String getD ()
    {
        return d;
    }

    public void setD (String d)
    {
        this.d = d;
    }
    
    

    public Rows getRows() {
		return Rows;
	}

	public String getRowspan ()
    {
        return rowspan;
    }

    public void setRowspan (String rowspan)
    {
        this.rowspan = rowspan;
    }

    public String getColPos ()
    {
        return colPos;
    }

    public void setColPos (String colPos)
    {
        this.colPos = colPos;
    }

    public String getCols ()
    {
        return cols;
    }

    public void setCols (String cols)
    {
        this.cols = cols;
    }

    public void setRows (Rows Rows)
    {
        this.Rows = Rows;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [colspan = "+colspan+", rowPos = "+rowPos+", d = "+d+", rowspan = "+rowspan+", colPos = "+colPos+", cols = "+cols+", Rows = "+Rows+"]";
    }
}
