package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @Responsebody, Spring bean
public class Lesson01Ex01RestController {

	// http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "<h3>@RestController를 사용해서 String을 리턴한다.</h3>";
	} // String -> HTML
	
	// http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("시계", "70만원");
		map.put("바다", "1000만원");
		map.put("컴퓨터", "90만원");
		
		return map;
	} // Map -> JSON String

	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); // 일반 java bean
		data.setId(100);
		data.setName("배진하");
		
		return data;
	} // 사용자정의 객체 -> JSON String
	
	// http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data(); // 일반 java bean
		data.setId(100);
		data.setName("배진하");

		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}








