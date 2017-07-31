package ie.cganalytics.orderhere.management.model;

import org.springframework.data.annotation.Id;

public class Location {

	@Id
	private String id;
	
	private String name;
	private String address;
	
	private String server;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
