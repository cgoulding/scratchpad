package ie.cganalytics.orderhere.management.repository.mongo;

import ie.cganalytics.orderhere.management.model.Location;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {

}
