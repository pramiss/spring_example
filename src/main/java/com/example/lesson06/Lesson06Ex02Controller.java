package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	@GetMapping("/add-user-view")
	public String addUserView() {
		return "lesson06/ex02AddUser";
	}
	
	// AJAX 요청 - 이름중복확인
	@ResponseBody
	@GetMapping("/is-duplication-name")
	public Map<String, Object> isDuplicationName(
			@RequestParam("name") String name) {
		// DB select - 중복검사
		boolean isDuplication = userBO.isDuplicationByName(name);
		
		// 응답 JSON
		// {"code":200, "is_duplication":true}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		return result;
	}
}
