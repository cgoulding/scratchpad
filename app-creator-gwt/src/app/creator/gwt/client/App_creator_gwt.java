package app.creator.gwt.client;

import app.creator.gwt.model.Application;
import app.creator.gwt.model.Artifact;
import app.creator.gwt.model.Entity;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App_creator_gwt implements EntryPoint {

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final CreatorServiceAsync creatorService = GWT
			.create(CreatorService.class);

	private Application application;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		application = new Application();
		application.setName("App Creator");
		 
		final Renderer renderer = new DraggableRenderer(1000, 1000);
		RootPanel.get("diagramContainer").add(renderer.getView());
		
		final TextBox entityName = new TextBox();
		entityName.setText("Entity1");

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		final Anchor downloadLink = new Anchor();
		downloadLink.setName("downloadLink");
		
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.add(downloadLink);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
			
		final Button saveButton = new Button("Save");
		
		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				saveButton.setEnabled(true);
				saveButton.setFocus(true);
			}
		});
		
		Button addButton = new Button("Add", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Entity entity = new Entity();
				entity.setName(entityName.getText());
				application.add(entity);
				renderer.render(new EntityTable(entity, renderer));
			}
		});
		
		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				// Then, we send the input to the server.
				saveButton.setEnabled(false);
				serverResponseLabel.setText("");
				save();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					save();
				}
			}

			private void save() {
				creatorService.create(application,
						new AsyncCallback<Artifact>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						downloadLink.setHTML("");
						downloadLink.setHref("");
						dialogBox.center();
						closeButton.setFocus(true);
					}

					public void onSuccess(Artifact result) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel.removeStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML("Successful");
						downloadLink.setHTML("Download application here: " + result.getName());
						downloadLink.setHref("/download?fileId=" + result.getId());
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
			}
		}

		MyHandler handler = new MyHandler();
		saveButton.addClickHandler(handler);
		saveButton.addKeyUpHandler(handler);
				
		HorizontalPanel addPanel = new HorizontalPanel();
		addPanel.add(entityName);
		addPanel.add(addButton);
		addPanel.add(saveButton);

		renderer.getView().add(addPanel);
	}
}