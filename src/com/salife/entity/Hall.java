package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hall implements Serializable{
	private int hid;
	private String name;
	private int cid;
	private int capacity;

	public Hall(String name, int cid) {
		super();
		this.name = name;
		this.cid = cid;
		this.capacity = 40;
	}

	public Hall(int hid, String name, int cid, int capacity) {
		super();
		this.hid = hid;
		this.name = name;
		this.cid = cid;
		this.capacity = 40;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Hall [hid=" + hid + ", name=" + name + ", cid=" + cid + ", capacity=" + capacity + "]";
	}

}
