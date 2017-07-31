package app.creator.gwt.client;

import com.allen_sauer.gwt.dnd.client.DragController;
import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.AbsolutePositionDropController;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.orange.links.client.DiagramController;
import com.orange.links.client.connection.Connection;

public class DraggableRenderer implements Renderer {

	private AbsolutePanel dropTarget;
	private DragController dragController;
	
	public DraggableRenderer(int width, int height) {
		dropTarget = new AbsolutePanel();
		dropTarget.setPixelSize(width, height);
		dragController = createDragController();
	}
	
	@Override
	public void render(Renderable renderable) {
		Widget draggable = createDraggableWidget(renderable);
		renderable.setContainer(draggable);
		dropTarget.add(draggable);
	}

	public DragController createDragController() {
		AbsolutePositionDropController dropController = new AbsolutePositionDropController(
				dropTarget);
		
		PickupDragController dragController = new PickupDragController(dropTarget, true);
		dragController.setBehaviorConstrainedToBoundaryPanel(true);
		dragController.setBehaviorMultipleSelection(false);
		dragController.setBehaviorDragStartSensitivity(5);
		dragController.registerDropController(dropController);
		
		return dragController;
	}
	
	public Widget createDraggableWidget(Renderable renderable) {
		// create the title bar
		HTML header = new HTML(renderable.getTitle());
				
		// create a panel to hold all our widgets
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(2);
		verticalPanel.addStyleName(renderable.getTitle() + "-DraggablePanel");
		verticalPanel.add(header);
		verticalPanel.add(renderable.getWidget());
				
		// make the panel draggable by its header
		dragController.makeDraggable(verticalPanel, header);

		return verticalPanel;
	}

	@Override
	public AbsolutePanel getView() {
		return dropTarget;
	}
}
