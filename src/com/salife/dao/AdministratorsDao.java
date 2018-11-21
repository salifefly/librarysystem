package com.salife.dao;

import java.util.ArrayList;

import com.salife.entity.Administrators;

public interface AdministratorsDao {
	public Administrators findByAccount(String account);

	public boolean correctPassword(Administrators administrator);

	public void save(Administrators administrator);

	public ArrayList<Administrators> findAll();

	public void deleteByAccount(Administrators administrator);

	public boolean confirm(Administrators administrator);

	public void update(Administrators administrator);

	public Administrators findById(int id);

	public void deleteById(int id);

	public String returnAccount(Administrators administrator);

	public ArrayList<Administrators> findByName(String name);

	public ArrayList<Administrators> findBySex(String sex);

	public ArrayList<Administrators> findByCId(int cid);

	public ArrayList<Administrators> searchAllAdmin();

	public int returncompInfo(String admin);

	public void finishInfo(String admin, int cid, String name, String sex, String email, String phonenumber);

	public int returnCid(String admin);

}
