package com.yeyunlin.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yeyunlin.dao.RegisterDao;
import com.yeyunlin.entity.User;
import com.yeyunlin.util.DBUtil;

public class RegisterDaoImp implements RegisterDao{

	@Override
	public void register(User user) {
		String sql = " insert into users(name , account , password , integral , icon )values(?,?,?,?,?) ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConn();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAccount());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getIntegral());
			preparedStatement.setString(5, user.getIcon());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}
}
