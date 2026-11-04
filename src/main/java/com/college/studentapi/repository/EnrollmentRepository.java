package com.college.studentapi.repository;

import com.college.studentapi.model.Enrollment;
import com.college.studentapi.model.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {
}