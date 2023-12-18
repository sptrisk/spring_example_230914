package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	@Autowired
	private ReviewMapper reviewMapper;
	
	// input : id  output : Review
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
		
}
