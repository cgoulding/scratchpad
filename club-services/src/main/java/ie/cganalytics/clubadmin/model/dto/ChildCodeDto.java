package ie.cganalytics.clubadmin.model.dto;

import ie.cganalytics.clubadmin.model.ChildCode;

public class ChildCodeDto implements ChildCode {

	private Long id;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private ParentCodeDto parent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	public String getAttribute3() {
		return attribute3;
	}
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	public String getAttribute4() {
		return attribute4;
	}
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}
	public String getAttribute5() {
		return attribute5;
	}
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}
	public ParentCodeDto getParent() {
		return parent;
	}
	public void setParent(ParentCodeDto parent) {
		this.parent = parent;
	}
	
	public String getLongDescription() {
		return getAttribute2();
	}
	public String getShortDescription() {
		return getAttribute3();
	}
}
