package com.salife.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class Recharge implements Serializable{
	private int uid;
	private long rechargeTime;
	private double money;
	
	

	public Recharge(int uid, double money) {
		super();
		this.uid = uid;
		this.rechargeTime = System.currentTimeMillis();
		this.money = money;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public long getRechargeTime() {
		return rechargeTime;
	}

	public void setRechargeTime(long rechargeTime) {
		this.rechargeTime = rechargeTime;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Recharge [uid=" + uid + ", rechargeTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rechargeTime) + ", money=" + money + "]";
	}
	
	

}
