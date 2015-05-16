package com.yeyunlin.dao;

import java.util.List;

import com.yeyunlin.entity.Review;

public interface ReviewDao {
	public void review(String userName,String reviewContent,String time);
	public String getReviews();
}
