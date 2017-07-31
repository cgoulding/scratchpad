package ie.cganalytics.clubadmin.model.hibernate;

import java.util.UUID;

import ie.cganalytics.clubadmin.model.OwnerPitchAssociation;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OWNER_PITCH_ASSOC")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class OwnerPitchAssociationImpl implements OwnerPitchAssociation {

	@Id
	@Column(name = "OWNER_PITCH_ASSOC_ID")
	private Long id;
	
	@JoinColumn(name = "PITCH_ID")
	@ManyToOne( cascade = {CascadeType.DETACH}, fetch=FetchType.LAZY )
	private PitchImpl pitch;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PitchImpl getPitch() {
		return pitch;
	}

	public void setPitch(PitchImpl pitch) {
		this.pitch = pitch;
	}
}
