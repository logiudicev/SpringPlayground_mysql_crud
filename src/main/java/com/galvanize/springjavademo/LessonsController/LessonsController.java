package com.galvanize.springjavademo.LessonsController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.galvanize.springjavademo.model.Lesson;
import com.galvanize.springjavademo.dao.LessonRepository;

import javax.persistence.Id;

@RestController
@RequestMapping("/")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/lesson")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("/lesson")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @PatchMapping("/lessons/{id}")
    public Lesson updateLesson(@RequestBody Lesson lesson,
                               @PathVariable Long id){

        if (this.repository.existsById(id)){
            Lesson oldLesson = this.repository.findById(id).get();
            oldLesson.setDeliveredOn(lesson.getDeliveredOn());

            this.repository.save(oldLesson);
        }
        else {
            //if no record
            return this.repository.save(lesson);
        }

        return lesson;
    }

}
