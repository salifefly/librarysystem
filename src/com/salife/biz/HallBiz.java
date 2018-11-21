package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Hall;

public interface HallBiz {
	
	public ArrayList<Hall> findByAll();
	public boolean findByHId(int hid);
	
	public boolean findByName(String name);
	
	public void addHall(Hall hall);
	
	public void deleteByHId(int hid,int cid);
	
	public void updateByHId(Hall hall);
	
	public int returnCId(int hid);
	
	public ArrayList<Hall>  searchByHId(int hid);
}
