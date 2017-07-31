package ie.cganalytics.clubadmin.model.hibernate;

import ie.cganalytics.clubadmin.model.Pitch;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PITCH")
public class PitchImpl implements Pitch {

	@Id
	@Column(name = "PITCH_ID")
	private Long id;
	
	@Column(name = "NAME")
    private String name;
	
	@Column(name = "NUMBER")
    private String number;
	
	@JoinColumn(name = "TYPE_CODE")
	@ManyToOne( cascade = {CascadeType.DETACH}, fetch=FetchType.EAGER )
    private ChildCodeImpl type;
	
	@JoinColumn(name = "SURFACE_CODE")
	@ManyToOne( cascade = {CascadeType.DETACH}, fetch=FetchType.EAGER )
    private ChildCodeImpl surface;
	
	@JoinColumn(name = "ADDRESS_ID")
	@OneToOne( cascade = {CascadeType.ALL}, fetch=FetchType.LAZY )
    private AddressImpl address;
	
	private String uuid;
	
	public PitchImpl() {
		uuid = UUID.randomUUID().toString();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public ChildCodeImpl getType() {
		return type;
	}
	public void setType(ChildCodeImpl type) {
		this.type = type;
	}
	public ChildCodeImpl getSurface() {
		return surface;
	}
	public void setSurface(ChildCodeImpl surface) {
		this.surface = surface;
	}
	public AddressImpl getAddress() {
		return address;
	}
	public void setAddress(AddressImpl address) {
		this.address = address;
	}
	public String getUuid() {
		return uuid;
	}
    
}
