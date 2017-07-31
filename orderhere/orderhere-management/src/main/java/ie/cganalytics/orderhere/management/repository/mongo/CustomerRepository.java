package ie.cganalytics.orderhere.management.repository.mongo;

import ie.cganalytics.orderhere.management.model.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
}
