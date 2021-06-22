package lu.uni.jakarta;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details of the JSON response for Employment data in Luxembourg")
public class JSONDocument {
	
	private int residentBorderes, nonResidentBorderes, nationalWageEarners, domesticWageEarners;
	private int nationalSeflEmployment, domesticSelfEmployment, nationalEmployment, domesticEmployment;
	private int numberUnemployed, activePopulation;
	private String year;
	
	public JSONDocument() {
		super();
		// TODO Auto-generated constructor stub
	}




	@ApiModelProperty(notes = "number of Resident Borderes working in Luxembourg")
	public int getResidentBorderes() {
		return residentBorderes;
	}




	public void setResidentBorderes(int residentBorderes) {
		this.residentBorderes = residentBorderes;
	}




	@ApiModelProperty(notes = "number of NON Resident Borderes working in Luxembourg")
	public int getNonResidentBorderes() {
		return nonResidentBorderes;
	}





	public void setNonResidentBorderes(int nonResidentBorderes) {
		this.nonResidentBorderes = nonResidentBorderes;
	}




	@ApiModelProperty(notes = "number of National Ware Earners working in Luxembourg")
	public int getNationalWageEarners() {
		return nationalWageEarners;
	}





	public void setNationalWageEarners(int nationalWageEarners) {
		this.nationalWageEarners = nationalWageEarners;
	}





	public int getDomesticWageEarners() {
		return domesticWageEarners;
	}





	public void setDomesticWageEarners(int domesticWageEarners) {
		this.domesticWageEarners = domesticWageEarners;
	}





	public int getNationalSeflEmployment() {
		return nationalSeflEmployment;
	}





	public void setNationalSeflEmployment(int nationalSeflEmployment) {
		this.nationalSeflEmployment = nationalSeflEmployment;
	}





	public int getDomesticSelfEmployment() {
		return domesticSelfEmployment;
	}





	public void setDomesticSelfEmployment(int domesticSelfEmployment) {
		this.domesticSelfEmployment = domesticSelfEmployment;
	}





	public int getNationalEmployment() {
		return nationalEmployment;
	}





	public void setNationalEmployment(int nationalEmployment) {
		this.nationalEmployment = nationalEmployment;
	}





	public int getDomesticEmployment() {
		return domesticEmployment;
	}





	public void setDomesticEmployment(int domesticEmployment) {
		this.domesticEmployment = domesticEmployment;
	}





	public int getNumberUnemployed() {
		return numberUnemployed;
	}





	public void setNumberUnemployed(int numberUnemployed) {
		this.numberUnemployed = numberUnemployed;
	}





	public int getActivePopulation() {
		return activePopulation;
	}





	public void setActivePopulation(int activePopulation) {
		this.activePopulation = activePopulation;
	}





	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}
	
	

	
	

}
