package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.HallBiz;
import com.salife.dao.HallDao;
import com.salife.dao.impl.HallDaoImpl;
import com.salife.entity.Hall;

public class HallBizImpl implements HallBiz {
	private HallDao hd = new HallDaoImpl();

	@Override
	public boolean findByHId(int hid) {
		if (hd.findByHId(hid).size() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public void addHall(Hall hall) {
		hd.addHall(hall);

	}

	@Override
	public void deleteByHId(int hid,int cid) {
		hd.deleteByHId(hid,cid);

	}

	@Override
	public void updateByHId(Hall hall) {
		hd.updateByHId(hall);

	}

	@Override
	public boolean findByName(String name) {
		ArrayList<Hall> al = hd.findByName(name);
		if (al.size() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public int returnCId(int hid) {

		return hd.returnCId(hid);
	}

	@Override
	public ArrayList<Hall> searchByHId(int hid) {
		ArrayList<Hall> al = hd.findByHId(hid);
		return al;
	}

	@Override
	public ArrayList<Hall> findByAll() {
		
		return hd.findByAll();
	}
}
