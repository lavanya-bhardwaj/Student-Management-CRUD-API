
package com.college.studentapi.controller;

import com.college.studentapi.model.Course;
import com.college.studentapi.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Course> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return repository.save(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(
            @PathVariable Integer id, @RequestBody Course course) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        course.setCourseId(id);
        return ResponseEntity.ok(repository.save(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
