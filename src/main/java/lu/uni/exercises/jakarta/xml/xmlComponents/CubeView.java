package lu.uni.exercises.jakarta.xml.xmlComponents;

import java.util.List;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;


@XmlRootElement(name = "CubeView")
@XmlAccessorType (XmlAccessType.FIELD)
public class CubeView
{

    private String CubeNotes;

    private String ReportTitle;

    private String Category;

    private String SourceInfo;

    @XmlElement(name = "Data")
    private Data Data;

    private String lang;

    private String script;


    public String getCubeNotes ()
    {
        return CubeNotes;
    }

    public void setCubeNotes (String CubeNotes)
    {
        this.CubeNotes = CubeNotes;
    }

    public String getReportTitle ()
    {
        return ReportTitle;
    }

    public void setReportTitle (String ReportTitle)
    {
        this.ReportTitle = ReportTitle;
    }

    public String getCategory ()
    {
        return Category;
    }

    public void setCategory (String Category)
    {
        this.Category = Category;
    }

    public String getSourceInfo ()
    {
        return SourceInfo;
    }

    public void setSourceInfo (String SourceInfo)
    {
        this.SourceInfo = SourceInfo;
    }

    public Data getData ()
    {
        return Data;
    }

    public void setData (Data Data)
    {
        this.Data = Data;
    }

    public String getLang ()
    {
        return lang;
    }

    public void setLang (String lang)
    {
        this.lang = lang;
    }

    public String getScript ()
    {
        return script;
    }

    public void setScript (String script)
    {
        this.script = script;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CubeNotes = "+CubeNotes+", ReportTitle = "+ReportTitle+", Category = "+Category+", SourceInfo = "+SourceInfo+", Data = "+Data+", lang = "+lang+", script = "+script+"]";
    }

}
