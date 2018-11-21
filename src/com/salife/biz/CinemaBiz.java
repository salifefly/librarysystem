package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Cinema;

public interface CinemaBiz {
	public boolean addCinmea(Cinema cinema);

	public ArrayList<Cinema> findAll();

	public boolean deleteCinema(Cinema cinema);
	
	public Cinema searchByAddress(String address);

	public boolean updateCinema(Cinema cinema);

	public boolean findByAddress(Cinema cinema);

	public boolean findByCId(int cid);

	public boolean findByName(String name);

	public ArrayList<Cinema> searchByName(String name);
	
	public Cinema searchByCId(int cid);

	public void deleteByCId(int cid);

	public void deleteByName(String name);

	public void updateByCid(int cid,String name);

}
