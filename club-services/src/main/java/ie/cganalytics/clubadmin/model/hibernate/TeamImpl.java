package ie.cganalytics.clubadmin.model.hibernate;

import ie.cganalytics.clubadmin.model.Team;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TEAM")
public class TeamImpl implements Team {
	
	@Id
	@Column(name = "TEAM_ID")
	private Long id;
	
	@JoinColumn(name = "LEVEL_CODE")
	@ManyToOne( cascade = {CascadeType.DETACH}, fetch=FetchType.EAGER )
	private ChildCodeImpl level;
	
	@ManyToOne( cascade = {CascadeType.DETACH}, fetch=FetchType.LAZY )
	@JoinColumn(name="CLUB_ID")
	private ClubImpl club;
	
	private String uuid;

	public TeamImpl() {
		uuid = UUID.randomUUID().toString();
	}
	
	public ClubImpl getClub() {
		return club;
	}
	public void setClub(ClubImpl club) {
		this.club = club;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ChildCodeImpl getLevel() {
		return level;
	}
	public void setLevel(ChildCodeImpl level) {
		this.level = level;
	}
	public String getUuid() {
		return uuid;
	}
}