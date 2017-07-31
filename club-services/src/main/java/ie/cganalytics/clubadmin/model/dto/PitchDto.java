package ie.cganalytics.clubadmin.model.dto;

import ie.cganalytics.clubadmin.model.Pitch;

public class PitchDto implements Pitch {

	private Long id;
    private String name;
    private String number;
    private ChildCodeDto type;
    private ChildCodeDto surface;
    private AddressDto address;
    
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
	public ChildCodeDto getType() {
		return type;
	}
	public void setType(ChildCodeDto type) {
		this.type = type;
	}
	public ChildCodeDto getSurface() {
		return surface;
	}
	public void setSurface(ChildCodeDto surface) {
		this.surface = surface;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
}
