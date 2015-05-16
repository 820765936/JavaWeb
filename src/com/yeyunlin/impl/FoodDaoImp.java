package com.yeyunlin.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yeyunlin.dao.FoodDao;
import com.yeyunlin.entity.Food;
import com.yeyunlin.util.DBUtil;
import com.yeyunlin.util.JsonUtil;

public class FoodDaoImp implements FoodDao{

	@Override
	public String getFoodList(String type) {
		String sql = " select number,name,price,type,icon,description from food where type = '"+type+"'";
		List<Food> foods = new ArrayList<Food>();
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.openConn();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Food food = new Food();
				food.setNumber(resultSet.getInt(1));
				food.setName(resultSet.getString(2));
				food.setPrice(resultSet.getInt(3));
				food.setType(resultSet.getString(4));
				food.setIcon(resultSet.getString(5));
				food.setDescription(resultSet.getString(6));
				foods.add(food);
			}
			return JsonUtil.setFoodJson(foods);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConn(connection);
		}
		return null;
	}
}
