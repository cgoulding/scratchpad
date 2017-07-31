package app.creator.gwt.client;

import app.creator.gwt.model.Entity;
import app.creator.gwt.model.Field;
import app.creator.gwt.model.Part;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class AbstractPartTable implements Renderable {

	private FlexTable table;
	
	private Widget container;
	
	private HTML tableName;
	
	private Integer propertyCount = 0;
	
	private Part part;
	
	private Renderer renderer;
	
	public AbstractPartTable(Part part, Renderer renderer) {
		this.part = part;
		this.renderer = renderer;
		this.tableName = new HTML(part.getName());
		this.table = createTable();
	}

	private FlexTable createTable() {
		// Create a Flex Table
		FlexTable table = new FlexTable();
		table.setWidget(0, 0, tableName);
		
		FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
		cellFormatter.setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_LEFT);

		final DialogBox editDialogBox = createEditEntityDialogBox();
		
		Button editButton = new Button(
				"Edit", new ClickHandler() {
					public void onClick(ClickEvent event) {
						editDialogBox.showRelativeTo(tableName);
					}
				});
		
		Button removeButton = new Button(
				"Remove", new ClickHandler() {
					public void onClick(ClickEvent event) {
						remove();
					}
				});

		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(editButton);
		buttonPanel.add(removeButton);
		table.setWidget(0, 1, buttonPanel);
		
		// Add one row to start
		for (Part row : part.getParts()) {
			renderRow(row);
		}
				
		Label addLabel = new Label();
		addLabel.setText("Add a");
		
		Button fieldButton = new Button(
				"Field", new ClickHandler() {
					public void onClick(ClickEvent event) {
						addNewField();
					}
				});
		
		Button partButton = new Button(
				"Part", new ClickHandler() {
					public void onClick(ClickEvent event) {
						addNewEntity();
					}
				});
		
		Button listButton = new Button(
				"List", new ClickHandler() {
					public void onClick(ClickEvent event) {
						addNewField();
					}
				});
		
		HorizontalPanel partPanel = new HorizontalPanel();
		partPanel.add(addLabel); 
		partPanel.add(fieldButton);
		partPanel.add(partButton);
		partPanel.add(listButton);
		
		table.setWidget(part.getParts().size() + 1, 0, partPanel);
		
		return table;
	}

	/**
	 * Add a row to the flex table.
	 */
	private void addNewField() {
		Field field = new Field();
		field.setName("Field " + propertyCount++);
		addRow(field);
	}
	
	private void addNewEntity() {
		final DialogBox addDialogBox = createAddEntityDialogBox();
		addDialogBox.showRelativeTo(table);
	}
	
	/**
	 * Add a row to the flex table.
	 */
	private void addRow(final Part row) {
		part.add(row);
		renderRow(row);
	}
	
	/**
	 * Add a row to the flex table.
	 */
	private void renderRow(final Part part) {
		switch(part.getType()) {
		case FIELD : {
			renderField((Field)part);
			break;
		}
		case ENTITY : {
			renderEntity((Entity)part);
			break;
		}
		case ENTITYLIST : {
			
		}
		default: renderField((Field)part);
		}
	}

	private void renderField(final Field field) {
		final TextBox propertyField = new TextBox();
		propertyField.setText(field.getName());
		propertyField.addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					addNewField();
					event.stopPropagation();
				}
			}
		});
		propertyField.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				field.setName(propertyField.getText());
			}
		});

		final Button editButton = new Button(
				"Edit", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						//load popup
					}
				});
		
		final Button removeButton = new Button(
				"Remove", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						Cell cell = table.getCellForEvent(event);
						removeRow(cell.getRowIndex());
					}
				});

		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(editButton);
		buttonPanel.add(removeButton);
		
		int numRows = table.getRowCount() - 1;
		table.insertRow(numRows);
		
		table.setWidget(numRows, 0, propertyField);
		table.setWidget(numRows, 1, buttonPanel);
		
		propertyField.setFocus(true);
		propertyField.selectAll();
	}
    
	private void renderEntity(final Entity entity) {
		final Label relationshipLabel = new Label();
		relationshipLabel.setText("has a: ");
		
		final Label entityLabel = new Label();
		entityLabel.setText(entity.getName());
		
		HorizontalPanel referencePanel = new HorizontalPanel();
		referencePanel.add(relationshipLabel);
		referencePanel.add(entityLabel);
		
		final Button editButton = new Button(
				"Edit", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						//load popup
					}
				});
		
		final Button removeButton = new Button(
				"Remove", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						Cell cell = table.getCellForEvent(event);
						removeRow(cell.getRowIndex());
					}
				});
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(editButton);
		buttonPanel.add(removeButton);
		
		VerticalPanel rowPanel = new VerticalPanel();
		rowPanel.add(referencePanel);
		rowPanel.add(buttonPanel);
		
		int numRows = table.getRowCount() - 1;
		table.insertRow(numRows);
		table.setWidget(numRows, 0, rowPanel);
		table.getFlexCellFormatter().setColSpan(numRows, 0, 2);

		renderer.render(new EntityTable(entity, renderer));
	}
	
	/**
	 * Remove a row from the flex table.
	 */
	private void removeRow(int row) {
		int numRows = table.getRowCount();
		if (numRows > 1) {
			part.remove(row);
			table.removeRow(row);
		}
	}
	
	public void remove() {
		getContainer().removeFromParent();	
	}
	
	private DialogBox createEditEntityDialogBox() {
		final DialogBox editDialogBox = new DialogBox();
		editDialogBox.setAnimationEnabled(true);
		editDialogBox.setText("Edit Popup");

		final TextBox editText = new TextBox();
		editText.setText(tableName.getText());

		Button applyButton = new Button(
				"Apply", new ClickHandler() {
					public void onClick(ClickEvent event) {
						setEntityName(editText.getText());
						editDialogBox.hide();
					}
				});
		
		final VerticalPanel editPanel = new VerticalPanel();
		editPanel.add(new HTMLPanel("Enter Name"));
		editPanel.add(editText);
		editPanel.add(applyButton);
		
		editDialogBox.setWidget(editPanel);
		
		return editDialogBox;
	}
	
	private DialogBox createAddEntityDialogBox() {
		final DialogBox addDialogBox = new DialogBox();
		addDialogBox.setAnimationEnabled(true);
		addDialogBox.setText("Add Part Popup");

		final TextBox addText = new TextBox();

		Button addButton = new Button(
				"Add", new ClickHandler() {
					public void onClick(ClickEvent event) {
						addDialogBox.hide();
						Entity newEntity = new Entity();
						newEntity.setName(addText.getText());
						addRow(newEntity);
					}
				});
		
		final VerticalPanel addPanel = new VerticalPanel();
		addPanel.add(new HTMLPanel("Enter Name"));
		addPanel.add(addText);
		addPanel.add(addButton);
		
		addDialogBox.setWidget(addPanel);
		
		return addDialogBox;
	}
	
	private void setEntityName(String name) {
		part.setName(name);
		tableName.setText(name);
	}
	
	public Widget getWidget() {
		return table;
	}
	
	public Widget getContainer() {
		if (container == null) {
			return table;
		}
		return container;
	}

	public void setContainer(Widget container) {
		this.container = container;
	}
}
