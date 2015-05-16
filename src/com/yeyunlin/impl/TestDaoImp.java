package com.yeyunlin.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yeyunlin.dao.TestDao;
import com.yeyunlin.util.DBUtil;

public class TestDaoImp implements TestDao{

	@Override
	public boolean isNameExit(String name) {
		String sql = " select * from users where name=? ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConn();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return false;
	}

	@Override
	public boolean isAccountExit(String account) {
		String sql = " select * from users where account = ? ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConn();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, account);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return false;
	}
}
