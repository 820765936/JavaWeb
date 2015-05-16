package com.yeyunlin.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yeyunlin.dao.FindDeskDao;
import com.yeyunlin.entity.Desk;
import com.yeyunlin.util.DBUtil;
import com.yeyunlin.util.JsonUtil;

public class DeskDaoImp implements FindDeskDao{

	@Override
	public int getDeskType(int deskNum) {
		String sql = " select flag from desk where id = ? ";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.openConn();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, deskNum);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConn(connection);
		}
		return 2;
	}

	@Override
	public int setDeskType(int flag,int deskNum) {
		String sql = " update desk set flag = ? where id = ? ";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.openConn();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, flag);
			preparedStatement.setInt(2, deskNum);
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConn(connection);
		}
		return 0;
	}

	@Override
	public String findUnuseDesk() {
		List<Desk> desks = new ArrayList<Desk>();
		String sql = " select * from desk where flag = 1 ";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.openConn();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Desk desk = new Desk();
				desk.setId(resultSet.getInt(1));
				desk.setFlag(resultSet.getInt(2));
				desks.add(desk);
			}
			return JsonUtil.setDeskJson(desks);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConn(connection);
		}
		return null;
	}
}
