package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.CinemaBiz;
import com.salife.dao.CinemaDao;
import com.salife.dao.impl.CinemaDaoImpl;
import com.salife.entity.Cinema;

public  class CinemaBizImpl implements CinemaBiz{
	private CinemaDao cd = new CinemaDaoImpl();

	@Override
	public boolean addCinmea(Cinema cinema) {
		if(cd.findByAddress(cinema.getAddress())==null) {
			cd.save(cinema);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Cinema> findAll() {
		return cd.findAll();
	}

	@Override
	public boolean deleteCinema(Cinema cinema) {
		if(cd.findByAddress(cinema.getAddress())!=null) {
			cd.delete(cinema);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCinema(Cinema cinema) {
		if(cd.findByAddress(cinema.getAddress())!=null) {
			cd.update(cinema);
			return true;
		}
		return false;
	}

	@Override
	public boolean findByAddress(Cinema cinema) {
		if(cd.findByAddress(cinema.getAddress())!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean findByCId(int cid) {
		if(cd.findByCId(cid)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean findByName(String name) {
		if(cd.findByName(name).size()!=0) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteByCId(int cid) {
		cd.deleteByCId(cid);
	}

	@Override
	public void deleteByName(String name) {
		
		
	}

	@Override
	public ArrayList<Cinema> searchByName(String name) {
		ArrayList<Cinema> al = cd.findByName(name);
		return al;
	}

	@Override
	public void updateByCid(int cid,String name) {
		cd.updateByCId(cid, name);
		
	}

	@Override
	public Cinema searchByCId(int cid) {
		Cinema cinema = cd.findByCId(cid);
		return cinema;
	}

	@Override
	public Cinema searchByAddress(String address) {

		return cd.findByAddress(address);
	}
	
}
