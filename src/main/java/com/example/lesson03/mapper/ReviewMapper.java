package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input : id(int)        -- from BO
	// output: Review or null -- to BO
	public Review selectReviewById(int id);
}
