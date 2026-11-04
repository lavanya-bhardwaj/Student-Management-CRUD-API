
package com.college.studentapi.controller;

import com.college.studentapi.model.Teacher;
import com.college.studentapi.repository.TeacherRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherRepository repository;

    public TeacherController(TeacherRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Teacher> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return repository.save(teacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> update(
            @PathVariable Integer id, @RequestBody Teacher teacher) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        teacher.setTeacherId(id);
        return ResponseEntity.ok(repository.save(teacher));
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
