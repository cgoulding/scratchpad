package ie.cganalytics.clubadmin.model.hibernate;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ie.cganalytics.clubadmin.model.Address;

@Entity
@Table(name = "ADDRESS")
public class AddressImpl implements Address {

	@Id
	@Column(name = "ADDRESS_ID")
	private Long id;
	
	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;
	
	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name = "CITY")
	private String city;
	
	@JoinColumn(name = "COUNTY_CODE")
	@ManyToOne( cascade = {CascadeType.DETACH}, fetch=FetchType.EAGER )
	private ChildCodeImpl county;
	
	@Column(name = "POSTALCODE")
    private String postalCode;
	
	@Column(name = "TOWN")
    private String town;
    
	private String uuid;
	
	public AddressImpl() {
		uuid = UUID.randomUUID().toString();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public ChildCodeImpl getCounty() {
		return county;
	}
	public void setCounty(ChildCodeImpl county) {
		this.county = county;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getUuid() {
		return uuid;
	}
}
