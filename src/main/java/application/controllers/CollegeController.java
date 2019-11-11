package application.controllers;
import application.entities.College;
import application.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    private  College college;

    @GetMapping("/college")
    public Flux<College> index() {
        return collegeService.findAll();
    }
    @GetMapping("/college/save")
    public Mono<College> save() {
        return collegeService.saveCollege(college);
    }


}
