package com.yeyunlin.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.yeyunlin.entity.Desk;
import com.yeyunlin.entity.Food;
import com.yeyunlin.entity.Review;
import com.yeyunlin.entity.User;

public class JsonUtil {
	
	public static String setJson(User user){
		String jsonResult = "";
		try {
			JSONObject object = new JSONObject();
			object.put("name", user.getName());
			object.put("account", user.getAccount());
			object.put("password", user.getPassword());
			object.put("integral", user.getIntegral());
			object.put("icon", user.getIcon());
			jsonResult = object.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	public static String setFoodJson(List<Food> foods){
		String jsonResult = "";
		try {
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < foods.size(); i++) {
				JSONObject object = new JSONObject();
				object.put("number", foods.get(i).getNumber());
				object.put("name", foods.get(i).getName());
				object.put("price", foods.get(i).getPrice());
				object.put("type", foods.get(i).getType());
				object.put("icon", foods.get(i).getIcon());
				object.put("description", foods.get(i).getDescription());
				jsonArray.add(object);
			}
			jsonObject.put("food", jsonArray);
			jsonResult = jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	public static String setReviewJson(List<Review> reviews){
		String jsonResult = "";
		try {
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < reviews.size(); i++) {
				JSONObject object = new JSONObject();
				object.put("name", reviews.get(i).getName());
				object.put("time", reviews.get(i).getTime());
				object.put("content", reviews.get(i).getContent());
				jsonArray.add(object);
			}
			jsonResult = jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	public static String setDeskJson(List<Desk> desks){
		String jsonResult = "";
		try {
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < desks.size(); i++) {
				JSONObject object = new JSONObject();
				object.put("id", desks.get(i).getId());
				object.put("flag", desks.get(i).getFlag());
				jsonArray.add(object);
			}
			jsonResult = jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonResult;
	}
}
