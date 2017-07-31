package ie.cganalytics.clubadmin.model.dto;

import ie.cganalytics.clubadmin.model.Club;
import ie.cganalytics.clubadmin.model.ClubSummary;

import java.util.List;

public class ClubDto implements Club, ClubSummary {

	private Long id;
	private List<TeamDto> teams;
	private String name;
	private AddressDto address;
	public List<OwnerPitchAssociationDto> pitches;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<TeamDto> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamDto> teams) {
		this.teams = teams;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public List<OwnerPitchAssociationDto> getPitches() {
		return pitches;
	}
	public void setPitches(List<OwnerPitchAssociationDto> pitches) {
		this.pitches = pitches;
	}
	
}
