package application.services;
import application.dao.CollegeDAO;
import application.entities.College;
import application.repositories.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CollegeService implements CollegeDAO {
    @Autowired
    private CollegeRepository collegeRepository;


    @Override
    public Mono<College> saveCollege(College college) {
     return    collegeRepository.save(college);
    }




    public Mono<College> findByID(long id) {
        return  collegeRepository.findById(id);
    }

    @Override
    public Flux<College> findAll() {
        return collegeRepository.findAll();
    }


    public Mono<Void> delete(College existingCollege) {

        return collegeRepository.delete(existingCollege);
    }

}
