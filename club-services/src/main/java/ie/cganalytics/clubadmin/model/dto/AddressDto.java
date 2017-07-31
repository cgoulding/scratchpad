package ie.cganalytics.clubadmin.model.dto;

import ie.cganalytics.clubadmin.model.Address;

public class AddressDto implements Address {

	private Long id;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private ChildCodeDto county;
    private String postalCode;
    private String town;
    
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
	public ChildCodeDto getCounty() {
		return county;
	}
	public void setCounty(ChildCodeDto county) {
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
}
