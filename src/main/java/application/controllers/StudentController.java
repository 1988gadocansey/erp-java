package application.controllers;

import application.entities.Student;
import application.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StudentController {
    @Autowired private StudentRepository studentRepository;
   /* // Colleges are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/students", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<College> streamAllTweets() {
        return collegeService.findAll();
    }
*/
    @GetMapping(value = "/stream/students",produces = MediaType.TEXT_EVENT_STREAM_VALUE)

    public Flux<Student> index() {

        return studentRepository.findAll();
    }


}
