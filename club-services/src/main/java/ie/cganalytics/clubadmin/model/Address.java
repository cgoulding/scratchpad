package ie.cganalytics.clubadmin.model;


public interface Address {

	Long getId();
	
	String getAddressLine1();
	
	String getAddressLine2();
	
	String getTown();
	
	String getCity();
	
	String getPostalCode();
	
	ChildCode getCounty();
	
}
