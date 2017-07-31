package app.creator.gwt.model;

import java.util.List;

public interface Part {

	String getName();
	void setName(String name);
	
	List<Part> getParts();
	boolean add(Part part);
	Part remove(int index);
	
	PartType getType();
}
