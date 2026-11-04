
package com.college.studentapi.controller;

import com.college.studentapi.model.Teaches;
import com.college.studentapi.model.TeachesId;
import com.college.studentapi.repository.TeachesRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/teaches")
public class TeachesController {

    private final TeachesRepository repository;

    public TeachesController(TeachesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Teaches> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{teacherId}/{courseId}")
    public ResponseEntity<Teaches> getById(
            @PathVariable Integer teacherId,
            @PathVariable Integer courseId) {
        TeachesId id = new TeachesId(teacherId, courseId);
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Teaches create(@RequestBody Teaches teaches) {
        return repository.save(teaches);
    }

    @PutMapping("/{teacherId}/{courseId}")
    public ResponseEntity<Teaches> update(
            @PathVariable Integer teacherId,
            @PathVariable Integer courseId,
            @RequestBody Teaches teaches) {
        TeachesId id = new TeachesId(teacherId, courseId);
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        teaches.setTeacherId(teacherId);
        teaches.setCourseId(courseId);
        return ResponseEntity.ok(repository.save(teaches));
    }

    @DeleteMapping("/{teacherId}/{courseId}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer teacherId,
            @PathVariable Integer courseId) {
        TeachesId id = new TeachesId(teacherId, courseId);
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
