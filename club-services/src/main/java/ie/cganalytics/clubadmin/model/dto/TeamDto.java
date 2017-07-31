package ie.cganalytics.clubadmin.model.dto;

import ie.cganalytics.clubadmin.model.Team;


public class TeamDto implements Team {
	
	private ClubSummaryDto club;
	private Long id;
	private ChildCodeDto level;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ClubSummaryDto getClub() {
		return club;
	}
	public void setClub(ClubSummaryDto club) {
		this.club = club;
	}
	public ChildCodeDto getLevel() {
		return level;
	}
	public void setLevel(ChildCodeDto level) {
		this.level = level;
	}
}
