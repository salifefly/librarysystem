package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.User;

public interface UserBiz {

	public boolean findByAccount(String account);
	
	public boolean logonUser(User user);
	
	public void regist(User user);
	
	public boolean FinishedPerfect(int userid);
	
	public int returnUid(User user);
	
	public ArrayList<User> userInfo(int userid);
	
	public void updateInfo(int userid,String name,String sex,String email,String phonenumber);
	
	public void setPerfectInfo(int userid);
	
	public double recharge(int userid,double balance);
	
	public double returnBalance(int userid);
	
	public int returnVip(int userid);
	
	public void setViplevel(int userid,int vip);
	
	public void setBalance(int userid,double money);
	
	public double discount(int vip);
	
	public void getBackMoney(ArrayList<Integer> al2,ArrayList<Double> al3);
	
	public void refundMoney(int userid,double refundmoney);

}
