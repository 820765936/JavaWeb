package com.yeyunlin.dao;

public interface FindDeskDao {
	public int getDeskType(int deskNum);
	public int setDeskType(int flag,int deskNum);
	public String findUnuseDesk();
}
