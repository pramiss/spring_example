package com.example.lesson01;

// Spring bean으로 가져올 필요없는 클래스 (Request, Response X)
// 단지 데이터를 저장하는 용도 (DB에 있는 데이터를 담을예정)
// 일반 Java bean
public class Data {
	// field
	private int id;
	private String name;

	// method
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
