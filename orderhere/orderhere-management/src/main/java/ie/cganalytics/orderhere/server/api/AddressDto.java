package ie.cganalytics.orderhere.server.api;

public class AddressDto {

	private String uuid;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String county;
	private String country;
	private String postalCode;
	private CoordinatesDto coordinates;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public CoordinatesDto getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(CoordinatesDto coordinates) {
		this.coordinates = coordinates;
	}
	
	
}
