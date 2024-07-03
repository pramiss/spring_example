package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	// Spring Data JPA vs 순수 JPA
	// Spring Data JPA Framework -- 메서드가 안보이지만 내장되어 있음
	
	// -- Framework 기본제공
	// public StudentEntity save(StudentEntity student)
	// public StudentEntity findById(int id)
	// public void delete(Entity entity)
	// public List<StudentEntity> findAll()
	
	// -- JPQL 문법 (ex02/select1)
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name111); // 매개변수 이름은 상관X
	public List<StudentEntity> findByNameIn(List<String> nameList);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String keyword);	
	// public List<StudentEntity> findByEmailLike(String keyword);	
	public List<StudentEntity> findByNameStartingWith(String keyword);
	// public List<StudentEntity> findByNameLike(String keyword);
	public List<StudentEntity> findByIdBetween(int startId, int endId);
}
