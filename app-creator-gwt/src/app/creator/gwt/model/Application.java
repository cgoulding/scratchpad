package app.creator.gwt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Application implements Part, Serializable {

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

	@Override
	public boolean add(Part part) {
		return parts.add((Entity)part);
	}

	@Override
	public Part remove(int index) {
		return parts.remove(index);
	}

	@Override
	public PartType getType() {
		return PartType.APPLICATION;
	}

}
