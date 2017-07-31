package ie.cganalytics.common;

import java.io.Serializable;

public interface Person extends Serializable {

	String getFirstName();
	
	String getLastName();
	
	void setFirstName(String firstName);
	
	void setLastName(String firstName);
	
}
