package com.yeyunlin.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.yeyunlin.dao.UpdateOrderDao;
import com.yeyunlin.util.DBUtil;

public class UpdateDaoImp implements UpdateOrderDao{

	@Override
	public void updateOrder(String paytype,String orderId) {
		String sql = " update foodorder set paytype = ? where order_id = ? ";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.openConn();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, paytype);
			preparedStatement.setString(2, orderId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConn(connection);
		}
	}

	@Override
	public void updateOrderDesk(int deskId, String orderId) {
		String sql = " update foodorder set desk_id = ? where order_id = ? ";
		DBUtil dbUtil = new DBUtil();
		Connection connection = dbUtil.openConn();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, deskId);
			preparedStatement.setString(2, orderId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConn(connection);
		}
	}
}
