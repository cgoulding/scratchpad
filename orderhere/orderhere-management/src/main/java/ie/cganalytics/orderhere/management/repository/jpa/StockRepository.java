package ie.cganalytics.orderhere.management.repository.jpa;

import ie.cganalytics.orderhere.management.model.Stock;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, String> {
	
}
