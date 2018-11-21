package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.CinemaDao;
import com.salife.entity.Cinema;

public class CinemaDaoImpl extends BaseDao implements CinemaDao {
	private ArrayList<Cinema> al;

	public CinemaDaoImpl() {
		file = new File("Cinema.txt");
	}

	@Override
	public Cinema findByAddress(String address) {
		al = read();
		Cinema cinema = null;
		for (int i = 0; i < al.size(); i++) {
			if (address.equals(al.get(i).getAddress())) {
				cinema = al.get(i);
			}
		}
		return cinema;
	}

	@Override
	public void save(Cinema cinema) {
		al = read();
		if (al.size() == 0) {
			cinema.setCid(1);
		} else {
			cinema.setCid(al.get(al.size() - 1).getCid() + 1);
		}
		al.add(cinema);
		write(al);

	}

	@Override
	public ArrayList<Cinema> findAll() {
		al = read();
		return al;
	}

	@Override
	public void delete(Cinema cinema) {
		al = read();
		al.remove(cinema);
		write(al);
	}

	@Override
	public void update(Cinema cinema) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (cinema.getAddress().equals(al.get(i).getAddress())) {
				al.get(i).setName(cinema.getName());
			}
		}
		write(al);
	}

	@Override
	public Cinema findByCId(int cid) {
		al = read();
		for(int i =0;i<al.size();i++) {
			if(cid==al.get(i).getCid()) {
				return al.get(i);
			}
		}
		return null;
	}

	@Override
	public void deleteByCId(int cid) {
		al = read();
		for(int i =0;i<al.size();i++) {
			if(cid==al.get(i).getCid()) {
				al.remove(i);
			}
		}
		write(al);
	}

	@Override
	public ArrayList<Cinema> findByName(String name) {
		al = read();
		ArrayList<Cinema> al2 = new ArrayList<>();
		for(int i =0;i<al.size();i++) {
			if(name.equals(al.get(i).getName())) {
				al2.add(al.get(i));
			}
		}
		return al2;
	}

	@Override
	public void updateByCId(int cid,String name) {
		al = read();
		for(int i = 0;i<al.size();i++) {
			if(cid==al.get(i).getCid()) {
				al.get(i).setName(name);
				break;
			}
		}
		write(al);
	}

}
