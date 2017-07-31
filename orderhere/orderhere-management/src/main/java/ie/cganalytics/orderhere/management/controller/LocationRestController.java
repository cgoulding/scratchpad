package ie.cganalytics.orderhere.management.controller;

import ie.cganalytics.orderhere.management.model.Location;
import ie.cganalytics.orderhere.management.model.ModelPopulator;
import ie.cganalytics.orderhere.management.repository.mongo.LocationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationRestController {

	@Autowired
	private LocationRepository repo;

	@Autowired
	private ModelPopulator populator;

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Location get(@PathVariable String id) {
		return repo.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Location> getAll() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Location create(@RequestBody Location location) {
		return repo.save(location);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable String id) {
		repo.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Location update(@PathVariable String id,
			@RequestBody Location location) {
		Location update = repo.findOne(id);
		populator.updateLocation(location, update);
		return repo.save(update);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Location> search(@RequestParam(value = "location", required = false) String location, 
			@RequestParam(value = "state", required = false) String state, 
			@RequestParam(value = "address", required = false) String address) {
		// @TODO implement search
		return repo.findAll();
	}
	
}
