
package com.college.studentapi.controller;

import com.college.studentapi.model.Enrollment;
import com.college.studentapi.model.EnrollmentId;
import com.college.studentapi.repository.EnrollmentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentRepository repository;

    public EnrollmentController(EnrollmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Enrollment> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{studentId}/{courseId}")
    public ResponseEntity<Enrollment> getById(
            @PathVariable Integer studentId,
            @PathVariable Integer courseId) {
        EnrollmentId id = new EnrollmentId(studentId, courseId);
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Enrollment create(@RequestBody Enrollment enrollment) {
        return repository.save(enrollment);
    }

    @PutMapping("/{studentId}/{courseId}")
    public ResponseEntity<Enrollment> update(
            @PathVariable Integer studentId,
            @PathVariable Integer courseId,
            @RequestBody Enrollment enrollment) {
        EnrollmentId id = new EnrollmentId(studentId, courseId);
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        enrollment.setStudentId(studentId);
        enrollment.setCourseId(courseId);
        return ResponseEntity.ok(repository.save(enrollment));
    }

    @DeleteMapping("/{studentId}/{courseId}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer studentId,
            @PathVariable Integer courseId) {
        EnrollmentId id = new EnrollmentId(studentId, courseId);
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
