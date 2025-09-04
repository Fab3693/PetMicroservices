package mentorship.roadmap.microservices.service_a.repository;

import mentorship.roadmap.microservices.service_a.repository.mongo.MessageDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository <MessageDocument, Long> {}
