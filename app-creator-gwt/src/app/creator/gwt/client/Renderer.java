package app.creator.gwt.client;

import com.google.gwt.user.client.ui.AbsolutePanel;


public interface Renderer {

	void render(Renderable renderable);
	AbsolutePanel getView(); 
	
}
