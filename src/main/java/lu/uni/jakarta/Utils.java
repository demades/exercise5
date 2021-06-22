package lu.uni.jakarta;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lu.uni.exercises.jakarta.xml.xmlComponents.CubeView;
import lu.uni.exercises.jakarta.xml.xmlComponents.Row;

public class Utils {
	
	private String inputDate;
	private static String outputDate;
	public List<String> dates;
	private static JSONDocument entry;
	private static List<Integer> splidate;

	public Utils(String inputDate) {
		super();
		this.inputDate = inputDate;
	}
	
	
	// Method to convert from a format of YYYYMM to "Month_name YYYY"
	public static String YeartoYearMonth(String input) {
		String year = "";
		String month = "";
		char[] tempYear = new char[4];
		for (int i =0; i<4 ; i++) {
			tempYear[i] = input.charAt(i);
		}
		if (input.length() == 6) {
		char[] tempMonth = new char[2];
		tempMonth[0] = input.charAt(4);
		tempMonth[1] = input.charAt(5);
		
		year = new String(tempYear);
		month = new String(tempMonth);
		
		switch(month) {
		
		case "01":
			month = "January";
			break;
		case "02":
			month = "February";
			break;
		case "03":
			month = "March";
			break;
		case "04":
			month = "April";
			break;
		case "05":
			month = "May";
			break;

		case "06":
			month = "June";
			break;

		case "07":
			month = "July";
			break;

		case "08":
			month = "August";
			break;

		case "09":
			month = "September";
			break;

		case "10":
			month = "October";
			break;

		case "11":
			month = "November";
			break;

		case "12":
			month = "December";
			break;

		}}else {
			char[] tempMonth = new char[1];
			tempMonth[0] = input.charAt(4);
			
			year = new String(tempYear);
			month = new String(tempMonth);
			
			switch(month) {
			
			case "1":
				month = "January";
				break;

			case "2":
				month = "February";
				break;

			case "3":
				month = "March";
				break;

			case "4":
				month = "April";
				break;

			case "5":
				month = "May";
				break;

			case "6":
				month = "June";
				break;

			case "7":
				month = "July";
				break;

			case "8":
				month = "August";
				break;

			case "9":
				month = "September";
				break;

		}}
		
		outputDate = month + " " + year;
		
		return outputDate;
		
	}
	// Returns an array with the list of months for a couple of fromDate / toDate
	public static List<String> getDatesRange(String fromDate, String toDate){
		List<String> dates = new ArrayList();
		List<Integer> fromDateArray = new ArrayList();
		List<Integer> toDateArray = new ArrayList();
		fromDateArray = splitYearMonth(fromDate);
		toDateArray = splitYearMonth(toDate);
		while (fromDateArray.get(0) < toDateArray.get(0)) {
			while (fromDateArray.get(1) < 12) {
				dates.add(fromDateArray.get(0).toString() + fromDateArray.get(1).toString());
				fromDateArray.set(1, fromDateArray.get(1)+1);
			}
			fromDateArray.set(0, fromDateArray.get(0)+1);
			fromDateArray.set(1, 1);
		}
		while (fromDateArray.get(1) <= toDateArray.get(1)) {
			dates.add(fromDateArray.get(0).toString() + fromDateArray.get(1).toString());
			fromDateArray.set(1, fromDateArray.get(1)+1);
		}
		return dates;
	}
	
	// Split an input YYYYMM to an Integer array with two entries (year / month) 
	private static List<Integer> splitYearMonth(String date){
		splidate = new ArrayList();
		char[] tempYear = new char[4];
		char[] tempMonth = new char[2];
		for (int i =0; i<4 ; i++) {
			tempYear[i] = date.charAt(i);
		}
		tempMonth[0] = date.charAt(4);
		tempMonth[1] = date.charAt(5);
		splidate.add(Integer.valueOf(String.valueOf(tempYear)));
		splidate.add(Integer.valueOf(String.valueOf(tempMonth)));		
		return splidate;
		
	}
	
	// create JSON with the information combined of two dates.
    public static JSONDocument CreateJsonFromXmlCombined(CubeView cubeView, List<String> months) {
    	List<JSONDocument> docs;
    	docs = new ArrayList();
    	JSONDocument doc = new JSONDocument();
    	Row[] rowList;
    	rowList = cubeView.getData().getRows().getRow();
    	JSONDocument entry;    	
    	for (int i=0; i<rowList.length; i++) {
    		for (int j=0; j<months.size(); j++) {
    			if (rowList[i].getRowLabels().getRowLabel().getValue().contains(Utils.YeartoYearMonth(months.get(j)))) {
    	    		entry = new JSONDocument();
    	    		entry.setYear(rowList[i].getRowLabels().getRowLabel().getValue());
    	    		entry.setResidentBorderes((int) Double.parseDouble(rowList[i].getCells().getC()[0].getV()));
    	    		entry.setNonResidentBorderes((int) Double.parseDouble(rowList[i].getCells().getC()[1].getV()));
    	    		entry.setNationalWageEarners((int) Double.parseDouble(rowList[i].getCells().getC()[2].getV()));
    	    		entry.setDomesticWageEarners((int) Double.parseDouble(rowList[i].getCells().getC()[3].getV()));
    	    		entry.setNationalSeflEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[4].getV()));
    	    		entry.setDomesticSelfEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[5].getV()));
    	    		entry.setNationalEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[6].getV()));
    	    		entry.setDomesticEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[7].getV()));
    	    		entry.setNumberUnemployed((int) Double.parseDouble(rowList[i].getCells().getC()[8].getV()));
    	    		entry.setActivePopulation((int) Double.parseDouble(rowList[i].getCells().getC()[9].getV())); 
    	    		docs.add(entry);
    			}
    		}

    	}
    	
    	doc = CombineMontlyData(docs); 	
    	return doc;
    }
    
    
    // create a json array with the difference of two months.
    private static JSONDocument CombineMontlyData(List<JSONDocument> docs) {
    	JSONDocument finalDocument = new JSONDocument();
    	finalDocument.setResidentBorderes(docs.get(docs.size() -1).getResidentBorderes() - docs.get(0).getResidentBorderes());
    	finalDocument.setNonResidentBorderes(docs.get(docs.size() -1).getNonResidentBorderes() - docs.get(0).getNonResidentBorderes());
    	finalDocument.setNationalWageEarners(docs.get(docs.size() -1).getNationalWageEarners() - docs.get(0).getNationalWageEarners());
    	finalDocument.setDomesticWageEarners(docs.get(docs.size() -1).getDomesticWageEarners() - docs.get(0).getDomesticWageEarners()) ;
    	finalDocument.setNationalSeflEmployment(docs.get(docs.size() -1).getNationalSeflEmployment() - docs.get(0).getNationalSeflEmployment());
    	finalDocument.setDomesticSelfEmployment(docs.get(docs.size() -1).getDomesticSelfEmployment() - docs.get(0).getDomesticSelfEmployment());
    	finalDocument.setNationalEmployment(docs.get(docs.size() -1).getNationalEmployment() - docs.get(0).getNationalEmployment());
    	finalDocument.setDomesticEmployment(docs.get(docs.size() -1).getDomesticEmployment() - docs.get(0).getDomesticEmployment());
    	finalDocument.setNumberUnemployed(docs.get(docs.size() -1).getNumberUnemployed() - docs.get(0).getNumberUnemployed());
    	finalDocument.setActivePopulation(docs.get(docs.size() -1).getActivePopulation() - docs.get(0).getActivePopulation());   	

    	return finalDocument;
    }
    
    //Create a json file with the employment values for a given day
    protected static String CreateJsonFromXml(CubeView cubeView, List<String> months) {
    	List<JSONDocument> docs = new ArrayList();
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	Row[] rowList = cubeView.getData().getRows().getRow();
    	for (int i=0; i<rowList.length; i++) {
    		for (int j=0; j<months.size(); j++) {
    			if (rowList[i].getRowLabels().getRowLabel().getValue().contains(Utils.YeartoYearMonth(months.get(j)))) {
    	    		entry = new JSONDocument();
    	    		entry.setYear(rowList[i].getRowLabels().getRowLabel().getValue());
    	    		entry.setResidentBorderes((int) Double.parseDouble(rowList[i].getCells().getC()[0].getV()));
    	    		entry.setNonResidentBorderes((int) Double.parseDouble(rowList[i].getCells().getC()[1].getV()));
    	    		entry.setNationalWageEarners((int) Double.parseDouble(rowList[i].getCells().getC()[2].getV()));
    	    		entry.setDomesticWageEarners((int) Double.parseDouble(rowList[i].getCells().getC()[3].getV()));
    	    		entry.setNationalSeflEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[4].getV()));
    	    		entry.setDomesticSelfEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[5].getV()));
    	    		entry.setNationalEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[6].getV()));
    	    		entry.setDomesticEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[7].getV()));
    	    		entry.setNumberUnemployed((int) Double.parseDouble(rowList[i].getCells().getC()[8].getV()));
    	    		entry.setActivePopulation((int) Double.parseDouble(rowList[i].getCells().getC()[9].getV())); 
    	    		docs.add(entry);
    			}
    		}

    	}	
    	return gson.toJson(docs);
    }
}
