package lu.uni.jakarta;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class ComposedDate {
	
	private String inputDate;
	private static String outputDate;
	private String[] dateParts;
	public List<String> dates;
	private static List<Integer> splidate;

	public ComposedDate(String inputDate) {
		super();
		this.inputDate = inputDate;
	}
	
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

}
