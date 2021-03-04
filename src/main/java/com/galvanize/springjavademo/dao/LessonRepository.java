package com.galvanize.springjavademo.dao;
import com.galvanize.springjavademo.model.Lesson;
import org.springframework.data.repository.CrudRepository;


public interface LessonRepository extends CrudRepository<Lesson, Long> {


}
