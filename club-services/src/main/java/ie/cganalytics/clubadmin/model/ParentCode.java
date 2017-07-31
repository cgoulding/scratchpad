package ie.cganalytics.clubadmin.model;

import java.util.List;

public interface ParentCode extends BasicCode {

	Long getId();
	
	String getAttribute1();
	
    String getAttribute2();

	String getAttribute3();

	String getAttribute4();

	String getAttribute5();
	
	List<? extends ChildCode> getChildren();
}
