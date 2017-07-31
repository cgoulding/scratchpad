package app.creator.gwt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Entity implements Part, Serializable {

	private String name;
	private List<Part> parts = new ArrayList<Part>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Part> getParts() {
		return parts;
	}
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
	public boolean add(Part e) {
		return parts.add(e);
	}
	public Part remove(int index) {
		return getParts().remove(index);
	}
	public PartType getType() {
		return PartType.ENTITY;
	}
}
