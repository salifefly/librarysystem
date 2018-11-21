package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.AdministratorsDao;
import com.salife.entity.Administrators;

public class AdministratorsDaoImpl extends BaseDao implements AdministratorsDao {
	private ArrayList<Administrators> al;

	public AdministratorsDaoImpl() {
		file = new File("Administrators.txt");
	}

	@Override
	public Administrators findByAccount(String account) {
		al = read();
		Administrators administrator = null;
		for (int i = 0; i < al.size(); i++) {
			if (account.equals(al.get(i).getAccount())) {
				administrator = al.get(i);
				break;
			}
		}
		return administrator;

	}

	@Override
	public void save(Administrators administrator) {
		al = read();
		if (al.size() == 0) {
			administrator.setAid(1);
		} else {
			administrator.setAid(al.get(al.size() - 1).getAid() + 1);
		}
		al.add(administrator);
		write(al);

	}

	@Override
	public ArrayList<Administrators> findAll() {
		al = read();
		return al;
	}

	@Override
	public boolean confirm(Administrators administrator) {// 这里是否是这样写的？
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (administrator.getAccount().equals(al.get(i).getAccount())
					&& administrator.getPassword().equals(al.get(i).getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void update(Administrators administrator) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (administrator.getAccount().equals(al.get(i).getAccount())) {
				al.get(i).setPassword(administrator.getPassword());
				break;
			}
		}
		write(al);

	}

	@Override
	public Administrators findById(int id) {
		al = read();
		Administrators administrator = null;
		for (int i = 0; i < al.size(); i++) {
			if (id == al.get(i).getAid()) {
				administrator = al.get(i);
			}
		}
		return administrator;
	}

	@Override
	public void deleteByAccount(Administrators administrator) {
		al = read();
		al.remove(administrator);
		write(al);

	}

	@Override
	public void deleteById(int id) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (id == al.get(i).getAid()) {
				al.remove(i);
			}
		}
		write(al);
	}

	@Override
	public String returnAccount(Administrators administrator) {
		String account = administrator.getAccount();
		return account;
	}

	@Override
	public ArrayList<Administrators> findByName(String name) {
		al = read();
		ArrayList<Administrators> al1 = new ArrayList<>();
		for (int i = 0; i < al.size(); i++) {
			if (name.equals(al.get(i).getName())) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public ArrayList<Administrators> findBySex(String sex) {
		al = read();
		ArrayList<Administrators> al1 = new ArrayList<>();
		for (int i = 0; i < al.size(); i++) {
			if (sex.equals(al.get(i).getSex())) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public ArrayList<Administrators> findByCId(int cid) {
		al = read();
		ArrayList<Administrators> al1 = new ArrayList<>();
		for (int i = 0; i < al.size(); i++) {
			if (cid == al.get(i).getCid()) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public boolean correctPassword(Administrators administrator) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (administrator.getAccount().equals(al.get(i).getAccount())
					&& administrator.getPassword().equals(al.get(i).getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Administrators> searchAllAdmin() {
		al = read();
		return al;
	}

	@Override
	public int returncompInfo(String admin) {
		al = read();
		int completeinfo = -1;
		for (int i = 0; i < al.size(); i++) {
			if (admin.equals(al.get(i).getAccount())) {
				completeinfo = al.get(i).getCompleteInfo();
			}
		}
		return completeinfo;
	}

	@Override
	public void finishInfo(String admin, int cid, String name, String sex, String email, String phonenumber) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (admin.equals(al.get(i).getAccount())) {
				al.get(i).setCid(cid);
				al.get(i).setName(name);
				al.get(i).setSex(sex);
				al.get(i).setEmail(email);
				al.get(i).setPhonenumber(phonenumber);
				al.get(i).setCompleteInfo(1);
			}
		}
		write(al);

	}

	@Override
	public int returnCid(String admin) {
		al = read();
		int admincid = -1;
		for(int i = 0;i<al.size();i++) {
			if(admin.equals(al.get(i).getAccount())) {
				admincid = al.get(i).getCid();
			}
		}
		return admincid;
	}

}
