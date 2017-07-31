package ie.cganalytics.clubadmin.model.hibernate;

import java.util.UUID;

import ie.cganalytics.clubadmin.model.OwnerType;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("CLUB")
public class ClubPitchAssociationImpl extends OwnerPitchAssociationImpl {

	@JoinColumn(name = "OWNER_ID", referencedColumnName = "CLUB_ID")
	@ManyToOne( cascade = {CascadeType.DETACH}, fetch=FetchType.LAZY )
	private ClubImpl club;
	
	private String uuid;
	
	public ClubPitchAssociationImpl() {
		uuid = UUID.randomUUID().toString();
	}
	
	public ClubImpl getClub() {
		return club;
	}

	public void setClub(ClubImpl club) {
		this.club = club;
	}

	public ClubImpl getOwner() {
		return getClub();
	}

	public OwnerType getOwnerType() {
		return OwnerType.CLUB;
	}
	
	public String getUuid() {
		return uuid;
	}
}
