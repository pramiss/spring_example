package com.example.lesson04.bo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// input: params, output: StudentEntity(방금 넣은 거)
	public StudentEntity addStudent(String name,
			String phoneNumber,String email, String dreamJob) {
		
		// builder 패턴으로 entity 생성 (장점: 하나의 트랜잭션으로 동작)
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략가능
				.updatedAt(LocalDateTime.now()) // @UpdateTimestamp 있으면 생략가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// input: Student, output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// input: id, output: Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
