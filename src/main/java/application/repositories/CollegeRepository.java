package application.repositories;
import application.entities.College;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author Gad Ocansey
 * @Since 1.0

 */
@Repository
public interface  CollegeRepository extends ReactiveCrudRepository<College, Long> {

}
