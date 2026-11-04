
package com.college.studentapi.controller;

import com.college.studentapi.model.Department;
import com.college.studentapi.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentRepository repository;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Department> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Department create(@RequestBody Department department) {
        return repository.save(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> update(
            @PathVariable Integer id, @RequestBody Department department) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        department.setDeptId(id);
        return ResponseEntity.ok(repository.save(department));
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
