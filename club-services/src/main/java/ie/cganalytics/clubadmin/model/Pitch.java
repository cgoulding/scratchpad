package ie.cganalytics.clubadmin.model;


public interface Pitch {

	Long getId();
	
	String getName();
	
	String getNumber();
	
	ChildCode getType();
	
	ChildCode getSurface();
	
	Address getAddress();

}
