package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Statistics implements Serializable {
	private int mid;
	private int number = 1;
	private double price;
	private double totalmovieprice;

	public Statistics(int mid, double price) {
		super();
		this.mid = mid;
		this.price = price;
	}

	public Statistics(int mid, int number, double price) {
		super();
		this.mid = mid;
		this.number = number;
		this.price = price;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTotalmovieprice(double totalmovieprice) {
		this.totalmovieprice = totalmovieprice;
	}

	public double getTotalmovieprice() {
		return number * price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mid;
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
		Statistics other = (Statistics) obj;
		if (mid != other.mid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Statistics [mid=" + mid + ", number=" + number + ", price=" + price + ", totalmovieprice="
				+ totalmovieprice + "]";
	}

}
