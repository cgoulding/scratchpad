package ie.cganalytics.orderhere.management.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ie.cganalytics.orderhere.management.model.LocationStock;

public interface LocationStockRepository extends MongoRepository<LocationStock, String> {

}
