package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.UserBiz;
import com.salife.dao.UserDao;
import com.salife.dao.impl.UserDaoImpl;
import com.salife.entity.User;

public class UserBizImpl implements UserBiz {
	private UserDao ud = new UserDaoImpl();

	@Override
	public boolean findByAccount(String account) {
		if (ud.findByAccount(account)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean logonUser(User user) {
		if (ud.logonUser(user)) {
			return true;
		}
		return false;
	}

	@Override
	public void regist(User user) {
		ud.regist(user);

	}

	@Override
	public boolean FinishedPerfect(int userid) {
		if(ud.FinishedPerfect(userid)==1) {
			return true;
		}
		return false;
	}

	@Override
	public int returnUid(User user) {
		
		return ud.returnUid(user);
	}

	@Override
	public ArrayList<User> userInfo(int userid) {
		
		return ud.userInfo(userid);
	}

	@Override
	public void updateInfo(int userid, String name, String sex, String email, String phonenumber) {
		ud.updateInfo(userid, name, sex, email, phonenumber);
		
	}

	@Override
	public void setPerfectInfo(int userid) {
		ud.setPerfectInfo(userid);
		
	}

	@Override
	public double recharge(int userid, double balance) {
		double afbalance = ud.recharge(userid,balance);
		return afbalance;
		
	}

	@Override
	public double returnBalance(int userid) {
		
		return ud.returnBalance(userid);
	}

	@Override
	public int returnVip(int userid) {
		
		return ud.returnVip(userid);
	}

	@Override
	public void setViplevel(int userid, int vip) {
		ud.setViplevel(userid, vip);
		
	}

	@Override
	public void setBalance(int userid, double money) {
		ud.setBalance(userid, money);
		
	}

	@Override
	public double discount(int vip) {
		
		return ud.discount(vip);
	}

	@Override
	public void getBackMoney(ArrayList<Integer> al2, ArrayList<Double> al3) {
		ud.getBackMoney(al2, al3);
		
	}

	@Override
	public void refundMoney(int userid, double refundmoney) {
		ud.refundMoney(userid, refundmoney);
		
	}

}
