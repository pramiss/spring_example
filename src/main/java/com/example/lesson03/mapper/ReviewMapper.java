package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input : id(int)        -- from BO
	// output: Review or null -- to BO
	public Review selectReviewById(int id);
	
	// input: Review, output: rowCount
	public int insertReview(Review review);
	
	// input: fields, output: rowCount
	// @Param 하나의 Map으로 xml에 전송
	public int insertReviewAsField(
			@Param("storeId") int storeId,
			@Param("menu") String menu,
			@Param("userName") String userName,
			@Param("point") Double point,
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
}
