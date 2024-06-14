package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController // Spring bean
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex01?id=7
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터 -- 다른 속성X
			// @RequestParam(value = "id") int id // 필수 파라미터 -- 없으면 에러
			// @RequestParam(value = "id", required = true) int id // 필수 파라미터 (위에선 required가 기본값인 true인 것이었음)
			// @RequestParam(value = "id", required = false) Integer id // 비필수 파라미터 -- !! Wrapper 클래스로 받아야함
			// @RequestParam(value = "id", defaultValue = "1") int id // 비필수 파라미터 + 기본값 1 -- required = false가 내장됨, null이 들어오는 경우는 없으니 int.
			) {
		
//		if (id == null) {
//			id = 1;
//		}
		
		return reviewBO.getReviewById(id); // response JSON String
	}
}
