package com.example.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	// Spring Data JPA vs 순수 JPA
	// 1. public StudentEntity save(StudentEntity student) -- 순수 JPA
	// 2. 메서드가 안보이지만 내장되어 있음 -- Spring Data JPA Framework
}
