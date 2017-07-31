package app.creator.gwt.client;

import com.google.gwt.user.client.ui.Widget;

public interface Renderable extends Removable {

	String getTitle();
	Widget getWidget();
	
}
