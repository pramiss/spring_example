package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController // @Controller + @ResponseBody
public class Lesson02Ex01RestController {

	@Autowired // Dependency Injection
	private UsedGoodsBO usedGoodsBO; // Spring bean 주입
	
	// http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList(); // 받아옴
		return usedGoodsList; // List -> Response JSON String
	}
}
