package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 보내는 컨트롤러
@Controller // @ResponseBody가 있으면 안됨!!
public class Lesson01Ex02Controller {
	
	// http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex03")
	public String ex02() {
		// return 되는 String은 html의 경로이다. (@ResponseBody가 없을때)
		
		// return "           lesson01/ex02     " : 단축경로
		// return "/templates/lesson01/ex02.html" : 실제경로
		return "lesson01/ex02"; // response html view 경로
	}
}
