package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
	// DELETE, input: id, output: X
	public void deleteStudentById(int id) {
		// 방법1) entity를 가져온 후 제거
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법2) optional 사용
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s)); // not null일때만 자동 수행
	}
	
	// UPDATE, input: id, dreamJob(변경할 값), output: StudentEntity or null
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// JPA에서 UPDATE하는 방법
		// 1. 기존 데이터를 조회해서 entity에 저장
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		if (student != null) {
			// 2. entity를 변경할 값으로 수정
			student = student.toBuilder() // toBuilder는 기존 필드값은 유지하고 일부만 변경
					.dreamJob(dreamJob).build(); // 꼭 객체에 다시 저장			
			// 3. entity를 DB에 넣음(save)
			student = studentRepository.save(student);
		}
		
		return student;
	}
	
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
