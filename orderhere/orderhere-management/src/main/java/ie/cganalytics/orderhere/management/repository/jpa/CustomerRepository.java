package ie.cganalytics.orderhere.management.repository.jpa;

import ie.cganalytics.orderhere.management.model.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	
}
