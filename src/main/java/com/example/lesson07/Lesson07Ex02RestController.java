package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {

	// !!!!! 이번에만 BO 생략 (프로젝트할때는 BO 생성하기)
	@Autowired
	private StudentRepository studentRepository;
	
	// 조회하는 다양한 방법
	@GetMapping("/select1")
	public List<StudentEntity> select1() {
		// 1) 전체 조회 (기본으로 제공됨)
		// return studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회
		// return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개만 조회
		// return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 김바다인 데이터 조회
		// return studentRepository.findByName("조세호");
		
		// 5) in문으로 일치하는 값 모두 조회
		// return studentRepository.findByNameIn(List.of("조세호", "유재석"));
		
		// 6) 여러 컬럼값과 일치하는 데이터 조회
		// return studentRepository.findByNameAndDreamJob("조세호", "변호사");
		
		// 7) like '%naver%' - email 칼럼에 naver가 포함된 데이터 조회
		// return studentRepository.findByEmailContains("naver"); 
		// return studentRepository.findByEmailLike("%naver%"); 
		
		// 8) like '김%' - 김으로 시작하는 데이터 조회
		// return studentRepository.findByNameStartingWith("김");
		// return studentRepository.findByNameLike("김%");
		
		// 9) id가 2~5까지 조회 - between
		return studentRepository.findByIdBetween(2, 5);
	}
	
	@GetMapping("/select2")
	public List<StudentEntity> select2() {
		// 장래희망이 래퍼인 데이터 조회
		return studentRepository.findByDreamJob("래퍼");
	}
	
	
	
	
	
	
	
	
	
	
}