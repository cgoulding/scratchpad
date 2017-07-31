package ie.cganalytics.clubadmin.model;

public interface ChildCode extends BasicCode {

	Long getId();

	String getAttribute1();
	
	String getAttribute2();

	String getAttribute3();

	String getAttribute4();

	String getAttribute5();
	
	ParentCode getParent();

}
