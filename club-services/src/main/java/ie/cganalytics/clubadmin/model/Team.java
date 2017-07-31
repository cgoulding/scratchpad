package ie.cganalytics.clubadmin.model;

import ie.cganalytics.clubadmin.walker.Walkable;

public interface Team extends Walkable {

	Long getId();
	
	ClubSummary getClub();
	
	public ChildCode getLevel();
	
}
