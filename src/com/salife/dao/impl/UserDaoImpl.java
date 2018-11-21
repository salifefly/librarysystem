package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.UserDao;
import com.salife.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {
	private ArrayList<User> al;

	public UserDaoImpl() {
		file = new File("User.txt");
	}

	@Override
	public boolean findByAccount(String account) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (account.equals(al.get(i).getAccount())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean logonUser(User user) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (user.getAccount().equals(al.get(i).getAccount())
					&& user.getPassword().equals(al.get(i).getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void regist(User user) {
		al = read();
		if (al.size() == 0) {
			user.setUid(1);
		} else {
			user.setUid(al.get(al.size() - 1).getUid() + 1);
		}
		al.add(user);
		write(al);
	}

	@Override
	public int returnUid(User user) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (user.getAccount().equals(al.get(i).getAccount())) {
				return al.get(i).getUid();
			}
		}
		return 0;
	}

	@Override
	public int FinishedPerfect(int userid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				return al.get(i).getPerfectInfo();
			}
		}
		return -1;
	}

	@Override
	public ArrayList<User> userInfo(int userid) {
		al = read();
		ArrayList<User> al2 = new ArrayList<User>();
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				al2.add(al.get(i));
				break;
			}
		}
		return al2;
	}

	@Override
	public void updateInfo(int userid, String name, String sex, String email, String phonenumber) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				al.get(i).setName(name);
				al.get(i).setSex(sex);
				al.get(i).setEmail(email);
				;
				al.get(i).setPhonenumber(phonenumber);
				break;
			}
		}
		write(al);

	}

	@Override
	public void setPerfectInfo(int userid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				al.get(i).setPerfectInfo(1);
			}
		}
		write(al);
		

	}

	@Override
	public double recharge(int userid, double balance) {
		al = read();
		double afbalance = 0;
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				al.get(i).setBalance(al.get(i).getBalance() + balance);
				afbalance = al.get(i).getBalance();
				break;
			}
		}
		write(al);
		return afbalance;

	}

	@Override
	public double returnBalance(int userid) {
		al = read();
		double balance = 0;
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				balance = al.get(i).getBalance();
				break;
			}
		}
		return balance;
	}

	@Override
	public int returnVip(int userid) {
		al = read();
		int vip = 0;
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				vip = al.get(i).getLevel();
				break;
			}
		}
		return vip;
	}

	@Override
	public void setViplevel(int userid, int vip) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				al.get(i).setLevel(vip);
				break;
			}
		}
		write(al);
	}

	@Override
	public void setBalance(int userid, double money) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				al.get(i).setBalance(al.get(i).getBalance() - money);
				break;
			}
		}
		write(al);
	}

	@Override
	public double discount(int vip) {
		double discount = 0;
		if (vip >= 0 && vip <= 3) {
			discount = 0.8;
		}else if(vip>3 &&vip<=6){
			discount = 0.6;
		}else {
			discount = 0.4;
		}
		return discount;

	}

	@Override
	public void getBackMoney(ArrayList<Integer> al2, ArrayList<Double> al3) {
		al = read();
		for(int i = 0;i<al2.size();i++) {
			for(int k = 0;k<al.size();k++) {
				if(al2.get(i)==al.get(k).getUid()) {
					al.get(i).setBalance(al.get(i).getBalance()+al3.get(i));
				}
			}
		}
		write(al);
	}

	@Override
	public void refundMoney(int userid, double refundmoney) {
		al = read();
		for(int i = 0;i<al.size();i++) {
			if(userid == al.get(i).getUid()) {
				al.get(i).setBalance(al.get(i).getBalance()+refundmoney);
			}
		}
		write(al);
		
	}

}
