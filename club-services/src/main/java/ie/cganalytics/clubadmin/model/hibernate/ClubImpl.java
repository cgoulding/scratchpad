package ie.cganalytics.clubadmin.model.hibernate;

import ie.cganalytics.clubadmin.model.Club;
import ie.cganalytics.clubadmin.model.ClubSummary;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLUB")
public class ClubImpl implements Club, ClubSummary {

	@Id
	@Column(name = "CLUB_ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="CLUB_ID")
	private List<TeamImpl> teams;
	
	@JoinColumn(name = "ADDRESS_ID")
	@OneToOne( cascade = {CascadeType.ALL}, fetch=FetchType.LAZY )
	private AddressImpl address;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="CLUB_ID")
	private List<ClubPitchAssociationImpl> pitches; 
	
	private String uuid;
	
	public ClubImpl() {
		uuid = UUID.randomUUID().toString();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TeamImpl> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamImpl> teams) {
		this.teams = teams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUuid() {
		return uuid;
	}

	public AddressImpl getAddress() {
		return address;
	}

	public void setAddress(AddressImpl address) {
		this.address = address;
	}

	public List<ClubPitchAssociationImpl> getPitches() {
		return pitches;
	}

	public void setPitches(List<ClubPitchAssociationImpl> pitches) {
		this.pitches = pitches;
	}
}
