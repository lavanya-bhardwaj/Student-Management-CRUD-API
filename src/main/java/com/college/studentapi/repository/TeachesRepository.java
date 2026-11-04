package com.college.studentapi.repository;

import com.college.studentapi.model.Teaches;
import com.college.studentapi.model.TeachesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachesRepository extends JpaRepository<Teaches, TeachesId> {
}