package program;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;

import model.Person;

public class TablePanel extends JPanel {
	
	private JTable table;
	private PersonTableModel tableModel;
	
	public TablePanel() {
		
		tableModel = new PersonTableModel();
		table = new JTable();
		
		setLayout(new BorderLayout());
		
		add(table, BorderLayout.CENTER);
	}
	public void setData(List<Person> db) {
		tableModel.setData(db);
	}
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
}
