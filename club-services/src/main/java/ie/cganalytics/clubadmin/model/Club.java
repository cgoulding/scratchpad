package ie.cganalytics.clubadmin.model;

import ie.cganalytics.clubadmin.walker.Walkable;

import java.util.List;

public interface Club extends ClubSummary, Walkable {

	Long getId();

	String getName();
	
	List<? extends Team> getTeams();
	
	List<? extends OwnerPitchAssociation> getPitches();
	
	Address getAddress();

}
