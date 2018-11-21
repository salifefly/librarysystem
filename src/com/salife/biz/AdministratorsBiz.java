package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Administrators;

public interface AdministratorsBiz {
	public boolean regist(Administrators administrator);

	public Administrators registSuccess(Administrators administrator);

	public boolean correctPassword(Administrators administrator);

	public ArrayList<Administrators> findAll();

	public boolean findByAccount(Administrators administrator);

	public boolean deleteByAccount(Administrators administrator);

	public boolean update(Administrators administrator);

	public Administrators searchAdmin(Administrators administrator);

	public boolean deleteById(int id);

	public boolean findById(int id);

	public boolean findByName(String name);

	public boolean findBySex(String sex);

	public boolean findByCId(int cid);

	public Administrators searchById(int id);

	public ArrayList<Administrators> searchByName(String name);

	public ArrayList<Administrators> searchBySex(String sex);

	public ArrayList<Administrators> searchByCId(int id);

	public String searchAdminById(int id);

	public ArrayList<Administrators> searchAllAdmin();

	public int returncompInfo(String admin);

	public void finishInfo(String admin, int cid, String name, String sex, String email, String phonenumber);
	
	public int returnCid(String admin);

}
