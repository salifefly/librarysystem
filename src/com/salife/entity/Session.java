package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Session implements Serializable {
	private int sid;
	private int cid;
	private int hid;
	private int mid;
	private String time;
	private double price;
	private int[][] remain;
	private int leftseat = 40;
	private String comments;

	public Session(int cid, int hid, int mid, String time) {
		super();
		this.cid = cid;
		this.hid = hid;
		this.mid = mid;
		this.time = time;
		this.remain = new int[5][8];
	}

	public Session(int sid, int cid, int hid, int mid, String time, double price, int remain, String comments) {
		super();
		this.sid = sid;
		this.cid = cid;
		this.hid = hid;
		this.mid = mid;
		this.time = time;
		this.price = price;
		this.remain = new int[5][8];
		this.comments = comments;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getLeftseat() {
		return leftseat;
	}

	public void setLeftseat(int leftseat) {
		this.leftseat = leftseat;
	}

	public int[][] getRemain() {
		return remain;
	}

	public void setRemain(int[][] remain) {
		this.remain = remain;
	}

	@Override
	public String toString() {
		return "Session [sid=" + sid + ", cid=" + cid + ", hid=" + hid + ", mid=" + mid + ", time=" + time + ", price="
				+ price + ", leftseat=" + leftseat + ", comments=" + comments + "]";
	}

}
