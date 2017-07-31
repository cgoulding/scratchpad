package ie.cganalytics.orderhere.management.controller;

import ie.cganalytics.orderhere.management.model.LocationStock;
import ie.cganalytics.orderhere.management.repository.mongo.LocationRepository;
import ie.cganalytics.orderhere.management.repository.mongo.LocationStockRepository;
import ie.cganalytics.orderhere.management.repository.mongo.StockRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locationstocks")
public class LocationStockRestController {

	@Autowired
	private LocationStockRepository repo;

	@Autowired
	private LocationRepository locationRepo;

	@Autowired
	private StockRepository stockRepo;

	@RequestMapping(method = RequestMethod.GET)
	public List<LocationStock> getAll() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public LocationStock create(@RequestBody LocationStock locationStock) {

		return repo.save(locationStock);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable String id) {
		repo.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public LocationStock update(@PathVariable String id,
			@RequestBody LocationStock locationStock) {
		LocationStock update = repo.findOne(id);
		update.setLocationId(locationStock.getLocationId());
		update.setStockId(locationStock.getStockId());
		return repo.save(update);
	}

}
