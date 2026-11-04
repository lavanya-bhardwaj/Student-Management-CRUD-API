
package com.college.studentapi.controller;

import com.college.studentapi.model.Student;
import com.college.studentapi.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(
            @PathVariable Integer id, @RequestBody Student student) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        student.setStudentId(id);
        return ResponseEntity.ok(repository.save(student));
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
