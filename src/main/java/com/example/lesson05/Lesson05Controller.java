package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("수박");
		fruits.add("파인애플");
		fruits.add("망고");
		fruits.add("키위");
		model.addAttribute("fruits", fruits);
		
		// List<Map<String, Object>>
		List<Map<String, Object>> users= new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "김진일");
		user.put("age", 17);
		user.put("hobby", "축구");
		users.add(user);
		
		user = new HashMap<>();
		user.put("name", "김바다");
		user.put("age", 20);
		user.put("hobby", "TV시청");
		users.add(user);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
}
