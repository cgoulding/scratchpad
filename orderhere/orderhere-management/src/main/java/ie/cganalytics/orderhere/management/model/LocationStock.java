package ie.cganalytics.orderhere.management.model;

import org.springframework.data.annotation.Id;

public class LocationStock {

	@Id
	private String id;
	
	private String locationId;
	
	private String stockId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
}
