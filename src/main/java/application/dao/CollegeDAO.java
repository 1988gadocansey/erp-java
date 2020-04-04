package application.dao;

import application.entities.College;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public interface CollegeDAO {
    Mono<College> saveCollege(College college);

    Flux<College> findAll();

}