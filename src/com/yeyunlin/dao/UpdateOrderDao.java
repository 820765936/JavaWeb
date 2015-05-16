package com.yeyunlin.dao;

public interface UpdateOrderDao {
	public void updateOrder(String paytype,String orderId);
	public void updateOrderDesk(int deskId,String orderId);
}
