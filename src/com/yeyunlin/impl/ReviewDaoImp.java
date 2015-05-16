package com.yeyunlin.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yeyunlin.dao.ReviewDao;
import com.yeyunlin.entity.Food;
import com.yeyunlin.entity.Review;
import com.yeyunlin.util.DBUtil;
import com.yeyunlin.util.JsonUtil;

public class ReviewDaoImp implements ReviewDao{

	@Override
	public void review(String userName, String reviewContent, String time) {
		String sql = " insert into reviews(name , content , time)values(?,?,?) ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConn();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, reviewContent);
			preparedStatement.setString(3, time);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}

	@Override
	public String getReviews() {
		String sql = " select * from reviews ";
		List<Review> reviews = new ArrayList<Review>();
		DBUtil util = new DBUtil();
		Connection conn = util.openConn();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Review review = new Review();
				review.setName(resultSet.getString(1));
				review.setContent(resultSet.getString(2));
				review.setTime(resultSet.getString(3));
				reviews.add(review);
			}
			return JsonUtil.setReviewJson(reviews);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}
}
