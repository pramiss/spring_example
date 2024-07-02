package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// C: create
	@GetMapping("/create")
	public StudentEntity create() {
		 String name = "이경아";
		 String phoneNumber = "010-2391-3910";
		 String email = "kyugA@naver.com";
		 String dreamJob = "간호사";
		 
		 // 객체(StudentEntity)를 리턴 -- JSON
		 return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
}
