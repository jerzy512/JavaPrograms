package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;
import program.FormEvent;

public class Controller {
	Database db = new Database();
	
	public List<Person> getPeople(){
		return db.getPeople();
	}
	
	public void removePerson(int index) {
		db.removePerson(index);
	}
	
	public void addPerson(FormEvent ev) {
		String name = ev.getName();
		String occupation = ev.getOccupation();
		int ageCat = ev.getAgeCategory();
		String empCat = ev.getEmploymentCategory();
		boolean isUS = ev.isUsCitizen();
		String taxId = ev.getTaxID();
		String gender = ev.getGender();
		
		AgeCategory ageCategory = null;
		
		switch (ageCat) {
		case 0:
			ageCategory = AgeCategory.CHILD;
			break;
		case 1:
			ageCategory = AgeCategory.ADULT;
			break;
		case 2:
			ageCategory = AgeCategory.SENIOR;
			break;
		}
		
		EmploymentCategory empCategory;
		
		if (empCat.equals("employed")) {
			empCategory = EmploymentCategory.EMPLOYED;
		} else if (empCat.equals("self-imployed")) {
			empCategory = EmploymentCategory.SELF_EMPLOYED;
		} else if (empCat.equals("unemployed")) {
			empCategory = EmploymentCategory.UNEMPLOYED;
		} else {
			empCategory = EmploymentCategory.OTHER;
		}
		
		Gender genderCat = null;
		
		if (gender.equals("male")) {
			genderCat = Gender.MALE;
		} else if (gender.equals("female")) {
			genderCat = Gender.FEMALE;
		}
		
		Person person = new Person(name, occupation, ageCategory, empCategory, taxId, isUS, genderCat);
		//System.out.println(name);
		db.addPerson(person);
	}
	public void saveToFile(File file) throws IOException {
		db.saveToFile(file);
	}
	public void loadFromFile(File file) throws IOException {
		db.loadFromFile(file);
	}
}
