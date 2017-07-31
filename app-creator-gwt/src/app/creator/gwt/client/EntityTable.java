package app.creator.gwt.client;

import app.creator.gwt.model.Entity;

public class EntityTable extends AbstractPartTable {
	
	public EntityTable(Entity entity, Renderer renderer) {
		super(entity, renderer);
	}
	
	public String getTitle() {
		return "Part";
	}
	
}
