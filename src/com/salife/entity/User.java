package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	private int uid;
	private String account;
	private String password;
	private int level;
	private double balance;
	private String name;
	private String sex;
	private String email;
	private String phonenumber;
	private int perfectInfo = 0;

	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public User(int uid, String account, String password, int level, double balance, String name, String sex,
			String email, String phonenumber) {
		super();
		this.uid = uid;
		this.account = account;
		this.password = password;
		this.level = level;
		this.balance = balance;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.phonenumber = phonenumber;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getPerfectInfo() {
		return perfectInfo;
	}

	public void setPerfectInfo(int perfectInfo) {
		this.perfectInfo = perfectInfo;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", account=" + account + ", password=" + password + ", level=" + level
				+ ", balance=" + balance + ", name=" + name + ", sex=" + sex + ", email=" + email + ", phonenumber="
				+ phonenumber + "]";
	}

}
