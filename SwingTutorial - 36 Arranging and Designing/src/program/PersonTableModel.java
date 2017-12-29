package program;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class PersonTableModel extends AbstractTableModel{
	
	private List<Person> db;
	
	private String[] colNames = {"Id", "Name", "Ocupation", "Age Category", "Employment Category", "US Citize", "Tax Id"};
	
	public PersonTableModel() {
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	public void setData(List<Person> db) {
		this.db = db;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Person person = db.get(row);
		switch(col) {
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2:
			return person.getOccupation();
		case 3:
			return person.getAgeCategory();
		case 4:
			return person.getEmpCat();
		case 5:
			return person.isUsCitizen();
		case 6:
			return person.getTaxID();
		}
		return null;
	}

}
