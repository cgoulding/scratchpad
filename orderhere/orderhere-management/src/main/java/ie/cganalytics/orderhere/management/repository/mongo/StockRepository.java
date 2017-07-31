package ie.cganalytics.orderhere.management.repository.mongo;

import ie.cganalytics.orderhere.management.model.Stock;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {
	
}
