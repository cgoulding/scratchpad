package ie.cganalytics.clubadmin.model.hibernate;

import ie.cganalytics.clubadmin.model.ChildCode;

import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHILD_CODE")
public class ChildCodeImpl implements ChildCode {
	
	@Id
	@Column(name = "CHILD_CODE_ID")
    private Long id;
    
    @Column(name = "ATTRIBUTE1")
	private String attribute1;
    
    @Column(name = "ATTRIBUTE2")
	private String attribute2;
    
    @Column(name = "ATTRIBUTE3")
	private String attribute3;
    
    @Column(name = "ATTRIBUTE4")
	private String attribute4;
    
    @Column(name = "ATTRIBUTE5")
	private String attribute5;
	
	@ManyToOne(cascade = {CascadeType.DETACH}, fetch=FetchType.EAGER)
    @JoinColumn(name="PARENT_CODE_ID")
	private ParentCodeImpl parent;
	
	private String uuid;
	
	public ChildCodeImpl() {
		uuid = UUID.randomUUID().toString();
	}
	
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

	public ParentCodeImpl getParent() {
		return parent;
	}

	public void setParent(ParentCodeImpl parent) {
		this.parent = parent;
	}

	public String getUuid() {
		return uuid;
	}

	public String getShortDescription() {
		return getAttribute1();
	}
	
	public String getLongDescription() {
		return getAttribute2();
	}
	
	
}
