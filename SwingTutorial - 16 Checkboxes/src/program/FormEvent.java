package program;

import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String occupation;
	private int ageCategory;
	private String empCat;
	private String taxID;
	private boolean usCitizen;

	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation, int ageCategory, String empCat,
			String taxID, boolean usCitizen) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.empCat = empCat;
		this.taxID = taxID;
		this.usCitizen = usCitizen;
	}

	final String getTaxID() {
		return taxID;
	}

	final boolean isUsCitizen() {
		return usCitizen;
	}

	final String getName() {
		return name;
	}

	final void setName(String name) {
		this.name = name;
	}

	final String getOccupation() {
		return occupation;
	}

	final void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getAgeCategory() {
		return ageCategory;
	}
	public String getEmploymentCategory() {
		return empCat;
	}
}
