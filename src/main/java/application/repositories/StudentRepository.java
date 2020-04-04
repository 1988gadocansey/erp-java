package application.repositories;
import application.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StudentRepository extends ReactiveCrudRepository<Student, String> {

    List<Student> findByFirstName(final String firstName);

    @Query("{'address.country': ?0}")
    List<Student> findByCountry(final String country);
}