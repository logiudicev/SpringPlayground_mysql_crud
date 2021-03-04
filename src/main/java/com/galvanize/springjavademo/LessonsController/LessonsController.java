package com.galvanize.springjavademo.LessonsController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.galvanize.springjavademo.model.Lesson;
import com.galvanize.springjavademo.dao.LessonRepository;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

}
