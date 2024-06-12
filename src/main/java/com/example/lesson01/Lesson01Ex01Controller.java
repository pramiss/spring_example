package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 클래스에 위치한 매핑이 먼저 읽힘
@Controller // Spring bean 등록
public class Lesson01Ex01Controller {
	
	// http://localhost:8080/lesson01/ex01/1
	@ResponseBody // return 값이 response body에 넣어짐.
	@RequestMapping("/1")
	public String ex01_1() {
		return "<h1>문자열을 Response Body에 보내는 예제</h1>";
	} // => String : HTML
	
	
	// http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("블루베리", 65);
		map.put("망고", 22);
		map.put("수박", 30);
		map.put("코코넛", 17);

		// map을 리턴하면 JSON이 된다.
		// spring web starter에 jackson 라이브러리가 포함되어 있기 때문 
		return map;
	} // => Map : JSON

}



