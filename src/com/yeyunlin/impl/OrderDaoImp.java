package com.yeyunlin.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yeyunlin.dao.OrderDao;
import com.yeyunlin.entity.Order;
import com.yeyunlin.util.DBUtil;

public class OrderDaoImp implements OrderDao {

	@Override
	public void insertOrder(Order order) {
		String sql = " insert into foodorder(order_id , user_name , food_id , desk_id , time , paytype)values(?,?,?,?,?,?) ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConn();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, order.getOrderId());
			preparedStatement.setString(2, order.getUsername());
			preparedStatement.setInt(3, order.getFoodid());
			preparedStatement.setInt(4, order.getDeskid());
			preparedStatement.setString(5, order.getTime());
			preparedStatement.setString(6, order.getPaytype());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}
}
