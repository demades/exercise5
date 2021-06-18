package lu.uni.jakarta;

public class ComposedDate {
	
	private String inputDate;
	private static String outputDate;
	private String[] dateParts;

	public ComposedDate(String inputDate) {
		super();
		this.inputDate = inputDate;
	}
	
	public static String YeartoYearMonth(String input) {
		String year = "";
		String month = "";
		char[] tempYear = new char[4];
		char[] tempMonth = new char[2];
		for (int i =0; i<4 ; i++) {
			tempYear[i] = input.charAt(i);
		}
		tempMonth[0] = input.charAt(4);
		tempMonth[1] = input.charAt(5);
		
		year = new String(tempYear);
		month = new String(tempMonth);
		
		switch(month) {
		
		case "01":
			month = "January";
		case "02":
			month = "February";
		case "03":
			month = "March";
		case "04":
			month = "April";
		case "05":
			month = "May";
		case "06":
			month = "June";
		case "07":
			month = "July";
		case "08":
			month = "August";
		case "09":
			month = "September";
		case "10":
			month = "October";
		case "11":
			month = "November";
		case "12":
			month = "December";
		}
		
		outputDate = month + " " + year;
		
		return outputDate;
		
	}

}
