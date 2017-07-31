package ie.cganalytics.orderhere.management.controller;

import ie.cganalytics.orderhere.management.model.Customer;
import ie.cganalytics.orderhere.management.model.ModelPopulator;
import ie.cganalytics.orderhere.management.repository.mongo.CustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerRepository repo;

	@Autowired
	private ModelPopulator populator;

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Customer get(@PathVariable String id) {
		return repo.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getAll() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Customer create(@RequestBody Customer customer) {
		return repo.save(customer);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable String id) {
		repo.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Customer update(@PathVariable String id,
			@RequestBody Customer customer) {
		Customer update = repo.findOne(id);
		update = populator.updateCustomer(customer, update);
		return repo.save(update);
	}

}
