package ie.cganalytics.orderhere.management.controller;

import ie.cganalytics.orderhere.management.model.ModelPopulator;
import ie.cganalytics.orderhere.management.model.Stock;
import ie.cganalytics.orderhere.management.repository.mongo.StockRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockRestController {

	@Autowired
	private StockRepository repo;

	@Autowired
	private ModelPopulator populator;

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Stock get(@PathVariable String id) {
		Stock stock = repo.findOne(id);
		return stock;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Stock> getAll() {
		return repo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Stock create(@RequestBody Stock stock) {
		return repo.save(stock);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable String id) {
		repo.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Stock update(@PathVariable String id, @RequestBody Stock stock) {
		Stock update = repo.findOne(id);
		update = populator.updateStock(stock, update);
		return repo.save(update);
	}

}
