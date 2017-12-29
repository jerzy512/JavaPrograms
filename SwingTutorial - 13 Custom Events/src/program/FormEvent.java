package program;

import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String occupation;

	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation) {
		super(source);
		this.name = name;
		this.occupation = occupation;
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

}
