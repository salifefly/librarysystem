package com.salife.dao;

import java.util.ArrayList;

import com.salife.entity.Hall;

public interface HallDao {
	public ArrayList<Hall> findByHId(int hid);

	public ArrayList<Hall> findByAll();

	public void addHall(Hall hall);

	public void deleteByHId(int hid, int cid);

	public void updateByHId(Hall hall);

	public ArrayList<Hall> findByName(String name);

	public int returnCId(int hid);

	public Hall findByHid(int hid);

}
