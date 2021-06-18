package lu.uni.exercises.jakarta.xml.xmlComponents;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rowLabel"
})
public class RowLabels
{
	@XmlElement(name="RowLabel", required = true)
    protected RowLabel rowLabel;

	public RowLabel getRowLabel() {
		return rowLabel;
	}

	public void setRowLabel(RowLabel rowLabel) {
		this.rowLabel = rowLabel;
	}


}
	