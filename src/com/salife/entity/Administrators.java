package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Administrators implements Serializable {
	private int aid;
	private int cid;
	private String account;
	private String password;
	private String name;
	private String sex;
	private String email;
	private String phonenumber;
	private double turnover;
	private int completeInfo = 0;

	public Administrators(String account) {
		super();
		this.account = account;
	}

	public Administrators(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public Administrators(int aid, int cid, String account, String password, String name, String sex, String email,
			String phonenumber, double turnover) {
		super();
		this.aid = aid;
		this.cid = cid;
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.phonenumber = phonenumber;
		this.turnover = turnover;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public int getCompleteInfo() {
		return completeInfo;
	}

	public void setCompleteInfo(int completeInfo) {
		this.completeInfo = completeInfo;
	}

	@Override
	public String toString() {
		return "Administrators [aid=" + aid + ", cid=" + cid + ", account=" + account + ", password=" + password
				+ ", name=" + name + ", sex=" + sex + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", turnover=" + turnover + "]";
	}

}
