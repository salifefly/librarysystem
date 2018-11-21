package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Turnover implements Serializable{
	private int cid;
	private double turnoverpd;
	// private double turnoverpm;

	public Turnover(int cid, double turnoverpd) {
		super();
		this.cid = cid;
		this.turnoverpd = turnoverpd;
	}

	public Turnover(int cid) {
		super();
		this.cid = cid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public double getTurnoverpd() {
		return turnoverpd;
	}

	public void setTurnoverpd(double turnoverpd) {
		this.turnoverpd = turnoverpd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
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
		Turnover other = (Turnover) obj;
		if (cid != other.cid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turnover [cid=" + cid + ", turnoverpd=" + turnoverpd + "]";
	}

}
