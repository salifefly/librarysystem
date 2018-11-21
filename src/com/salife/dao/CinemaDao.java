package com.salife.dao;

import java.util.ArrayList;

import com.salife.entity.Cinema;

public interface CinemaDao {
	public Cinema findByAddress(String address);

	public void save(Cinema cinema);

	public ArrayList<Cinema> findAll();
	
	public void delete(Cinema cinema);
	
	public Cinema findByCId(int cid);
	
	public ArrayList<Cinema> findByName(String name);
	
	public void update(Cinema cinema);
	
	public void deleteByCId(int cid);
	
	public void updateByCId(int cid,String name);
	
}
