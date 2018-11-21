package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.HallDao;
import com.salife.entity.Hall;

public class HallDaoImpl extends BaseDao implements HallDao {
	private ArrayList<Hall> al;

	public HallDaoImpl() {
		file = new File("Hall.txt");
	}

	@Override
	public ArrayList<Hall> findByHId(int hid) {
		al = read();
		ArrayList<Hall> al1 = new ArrayList<Hall>();
		for (int i = 0; i < al.size(); i++) {
			if (hid == al.get(i).getHid()) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public void addHall(Hall hall) {
		al = read();
		if (al.size() == 0) {
			hall.setHid(1);
		} else {
			hall.setHid(al.get(al.size() - 1).getHid() + 1);
		}
		al.add(hall);
		write(al);

	}

	@Override
	public void deleteByHId(int hid, int cid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (hid == al.get(i).getHid() && cid == al.get(i).getCid()) {
				al.remove(i);
				break;
			}
		}
		write(al);

	}

	@Override
	public void updateByHId(Hall hall) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (hall.getHid() == al.get(i).getHid()) {
				al.set(i, hall);
				break;
			}
		}
		write(al);
	}

	@Override
	public ArrayList<Hall> findByName(String name) {
		al = read();
		ArrayList<Hall> al1 = new ArrayList<Hall>();
		for (int i = 0; i < al.size(); i++) {
			if (name.equals(al.get(i).getName())) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public int returnCId(int hid) {
		al = read();
		int cid = 0;
		for (int i = 0; i < al.size(); i++) {
			if (hid == al.get(i).getHid()) {
				cid = al.get(i).getCid();
			}
		}
		return cid;
	}

	@Override
	public Hall findByHid(int hid) {
		al =read();
		Hall hall = null;
		for(int i = 0;i<al.size();i++) {
			if(hid==al.get(i).getHid()) {
				hall = al.get(i);
			}
		}
		return hall;
	}

	@Override
	public ArrayList<Hall> findByAll() {
		al = read();
		return al;
	}
}
