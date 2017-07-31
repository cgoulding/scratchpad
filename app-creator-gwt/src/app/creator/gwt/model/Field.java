package app.creator.gwt.model;

import java.io.Serializable;
import java.util.List;

public class Field implements Part, Serializable {

	private String name;
	private Attributes attributes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public PartType getType() {
		return PartType.FIELD;
	}
	
	public List<Part> getParts() {
		return null;
	}

	public boolean add(Part part) {
		return false;
	}

	public Part remove(int index) {
		return null;
	}
}
