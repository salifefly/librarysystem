package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Consumption implements Serializable{
	private int conid;
	private int uid;
	private String buytime;
	private double money;

	public Consumption(int uid, String buytime, double money) {
		super();
		this.uid = uid;
		this.buytime = buytime;
		this.money = money;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getBuytime() {
		return buytime;
	}

	public void setBuytime(String buytime) {
		this.buytime = buytime;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getConid() {
		return conid;
	}

	public void setConid(int conid) {
		this.conid = conid;
	}

	@Override
	public String toString() {
		return "Consumption [conid=" + conid + ", uid=" + uid + ", buytime=" + buytime + ", money=" + money + "]";
	}

}
