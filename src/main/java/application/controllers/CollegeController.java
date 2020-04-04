package application.controllers;
import application.entities.College;
import application.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

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
    public Mono<College> save(@Valid @RequestBody College college) {
        //return collegeService.saveCollege(college);
        return collegeService.saveCollege(college);

    }

    @GetMapping("/college/{id}")
    public Mono<ResponseEntity<College>> getCollegeById(@PathVariable(value = "id") long collegeId) {
        return collegeService.findByID(collegeId)
                .map(savedCollege -> ResponseEntity.ok(savedCollege))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/college/{id}")
    public Mono<ResponseEntity<College>> updateCollege(@PathVariable(value = "id") long collegeId,
                                                   @Valid @RequestBody College college) {
        return collegeService.findByID(collegeId)
                .flatMap(existingCollege -> {
                    existingCollege.setName(college.getName());
                    return collegeService.saveCollege(existingCollege);
                })
                .map(updatedCollege -> new ResponseEntity<>(updatedCollege, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/college/{id}")
    public Mono<ResponseEntity<Void>> deleteCollege(@PathVariable(value = "id") long collegeId) {

        return collegeService.findByID(collegeId)
                .flatMap(existingCollege ->
                        collegeService.delete(existingCollege)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Colleges are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/colleges", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<College> streamAllTweets() {
        return collegeService.findAll();
    }


}
