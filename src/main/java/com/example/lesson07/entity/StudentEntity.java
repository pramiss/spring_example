package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Lombok 역할
@ToString // 객체 출력시 필드 값이 보임. toString은 항상 오버라이드 권장.
@AllArgsConstructor // JPA는 생성자가 필요함.  모든 파라미터가 있는 생성자
@NoArgsConstructor // 아무 파라미터가 없는 생성자
@Builder // setter를 대신해서 내용을 담음
@Getter // getter를 만들어줌
// JPA 역할
@Table(name = "new_student") // JPA에게 연결할 table을 알려줌
@Entity // 이 객체가 Entity임을 알려줌 BO-JPA-DB
public class StudentEntity {
	@Id // pk를 알려줌, id가 복합키면 다른 어노테이션을 사용함
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 방금 들어온(insert) id를 가져옴. useGeneratedKeys와 같은 역할
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber") // CamelCase 사용시
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@CreationTimestamp // 시간값이 없어도 현재시간으로 들어감. 업데이트시 변경 X
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // 생성 및 업데이트마다 현재시간으로 변경
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}
