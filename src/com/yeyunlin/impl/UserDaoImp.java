package com.yeyunlin.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yeyunlin.dao.UserDao;
import com.yeyunlin.entity.User;
import com.yeyunlin.util.DBUtil;
import com.yeyunlin.util.JsonUtil;

public class UserDaoImp implements UserDao{

	@Override
	public String login(String account, String password) {
		String sql = " select name,account,password,integral,icon "+
				" from users "+
				" where account=? and password=? ";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.openConn();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, account);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				user.setName(resultSet.getString(1));
				user.setAccount(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setIntegral(resultSet.getInt(4));
				user.setIcon(resultSet.getString(5));
				return JsonUtil.setJson(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConn(connection);
		}
		return null;
	}
}
