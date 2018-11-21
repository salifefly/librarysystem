package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.AdministratorsBiz;
import com.salife.dao.AdministratorsDao;
import com.salife.dao.impl.AdministratorsDaoImpl;
import com.salife.entity.Administrators;

public class AdministratorsBizImpl implements AdministratorsBiz {
	private AdministratorsDao ad = new AdministratorsDaoImpl();

	@Override
	public boolean regist(Administrators administrator) {
		if (ad.findByAccount(administrator.getAccount()) == null) {
			ad.save(administrator);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Administrators> findAll() {
		return ad.findAll();
	}

	@Override
	public boolean findByAccount(Administrators administrator) {
		if (ad.findByAccount(administrator.getAccount()) == null) {
			return false;
		}
		return true;
	}

	public boolean update(Administrators administrator) {
		if (ad.confirm(administrator)) {
			return false;
		}
		ad.update(administrator);
		return true;
	}

	@Override
	public Administrators searchAdmin(Administrators administrator) {
		Administrators administrator1 = ad.findByAccount(administrator.getAccount());
		return administrator1;
	}

	@Override
	public boolean deleteById(int id) {
		if (ad.findById(id) != null) {
			ad.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteByAccount(Administrators administrator) {
		if (ad.confirm(administrator)) {
			ad.deleteByAccount(administrator);
			return true;
		}
		return false;
	}

	@Override
	public Administrators registSuccess(Administrators administrator) {
		Administrators administrator2 = ad.findByAccount(administrator.getAccount());
		return administrator2;
	}

	@Override
	public boolean findById(int id) {
		if (ad.findById(id) != null) {
			return true;
		}
		return false;
	}

	@Override
	public String searchAdminById(int id) {
		Administrators administrator = ad.findById(id);
		return ad.returnAccount(administrator);
	}

	@Override
	public Administrators searchById(int id) {
		Administrators administrator = ad.findById(id);
		return administrator;
	}

	@Override
	public ArrayList<Administrators> searchByName(String name) {
		ArrayList<Administrators> al = ad.findByName(name);
		return al;
	}

	@Override
	public ArrayList<Administrators> searchBySex(String sex) {
		ArrayList<Administrators> al = ad.findBySex(sex);
		return al;
	}

	@Override
	public ArrayList<Administrators> searchByCId(int cid) {
		ArrayList<Administrators> al = ad.findByCId(cid);
		return al;
	}

	@Override
	public boolean findByName(String name) {
		if (ad.findByName(name).size() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean findBySex(String sex) {
		if (ad.findBySex(sex).size() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean findByCId(int cid) {
		if (ad.findByCId(cid).size() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean correctPassword(Administrators administrator) {
		if (ad.correctPassword(administrator)) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Administrators> searchAllAdmin() {

		return ad.searchAllAdmin();
	}

	@Override
	public int returncompInfo(String admin) {

		return ad.returncompInfo(admin);
	}

	@Override
	public void finishInfo(String admin, int cid, String name, String sex, String email, String phonenumber) {
		ad.finishInfo(admin, cid, name, sex, email, phonenumber);

	}

	@Override
	public int returnCid(String admin) {
		
		return ad.returnCid(admin);
	}

}
