package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cinema implements Serializable{
	private int cid;
	private String name;
	private String address;

	public Cinema(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Cinema(String address) {
		super();
		this.address = address;
	}

	public Cinema(int cid, String name, String address) {
		super();
		this.cid = cid;
		this.name = name;
		this.address = address;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Cinema [cid=" + cid + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}

}
