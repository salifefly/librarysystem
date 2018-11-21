package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Ticket implements Serializable{
	private int tid;
	private int uid;
	private int cid;
	private int sid;
	private int hid;
	private int mid;
	private String seat;
	private double price;
	private String startTime;
	private String overTime;
	private String comments;

	public Ticket(int uid, int cid, int sid, int hid, int mid, String seat, double price, String startTime,
			String overTime) {
		super();
		this.uid = uid;
		this.cid = cid;
		this.sid = sid;
		this.hid = hid;
		this.mid = mid;
		this.seat = seat;
		this.price = price;
		this.startTime = startTime;
		this.overTime = overTime;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Ticket [tid=" + tid + ", uid=" + uid + ", cid=" + cid + ", sid=" + sid + ", hid=" + hid + ", mid=" + mid
				+ ", seat=" + seat + ", price=" + price + ", startTime=" + startTime + ", overTime=" + overTime
				+ ", comments=" + comments + "]";
	}

}
