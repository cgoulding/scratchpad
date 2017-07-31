package ie.cganalytics.orderhere.management.model;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ModelPopulator {

	public Customer updateCustomer(Customer source, Customer destination) {
		destination.setAddress(source.getAddress());
		destination.setEmail(source.getEmail());
		destination.setFirstName(source.getFirstName());
		destination.setLastName(source.getLastName());
		destination.setPhoneNumber(source.getPhoneNumber());
		return destination;
	}

	public Location updateLocation(Location source, Location update) {
		update.setName(source.getName());
		update.setServer(source.getServer());
		update.setAddress(source.getAddress());
		return update;
	}
	
	public Stock updateStock(Stock source, Stock destination) {
		if (source.getItems() != null)
		{
			for (StockItem item : source.getItems())
			{
				if (item.getId() == null)
				{
					item.setId(UUID.randomUUID().toString());
				}
			}
		}
		destination.setItems(source.getItems());
		return destination;
	}
}
