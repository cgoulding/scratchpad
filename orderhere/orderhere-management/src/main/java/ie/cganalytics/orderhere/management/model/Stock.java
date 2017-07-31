package ie.cganalytics.orderhere.management.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Stock {

	@Id
	private String id;
	private String name;
	private String description;
	private List<StockItem> items;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<StockItem> getItems() {
		return items;
	}
	public void setItems(List<StockItem> items) {
		this.items = items;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
