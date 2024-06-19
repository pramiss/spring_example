package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {

	@Autowired
	private StudentBO studentBO;
	
	
	// 학생 가입 화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// DB에 학생 insert -> DB에서 방금 가입된 학생 select -> 화면 뿌리기
	// Student 도메인에 해당하는 field가 있으면 자동 할당됨
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student) {
		
		// DB Insert
		studentBO.addStudent(student);
		
		// DB Select => 위에서 가입된 학생
		
		// Model에 데이터를 담는다.
		
		// 화면 이동 (먼저 검증)
		return "lesson04/afterAddStudent";
	}
}
