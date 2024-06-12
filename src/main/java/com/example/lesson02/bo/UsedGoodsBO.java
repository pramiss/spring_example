package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // Spring bean 등록
public class UsedGoodsBO {

	// input: X (Controller로 부터 들어온 요청)
	// output: (Repository한테 받은 것을) List<UsedGoods> (Controller에게 줌)
	public List<UsedGoods> getUsedGoodsList() {
		
	}
}
