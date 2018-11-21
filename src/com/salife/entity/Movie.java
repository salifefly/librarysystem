package com.salife.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Movie implements Serializable{
	private int mid;
	private String name;
	private String detail;
	private String duration;
	private String type;
	private double price;
	private String comments;

	public Movie(String name, String detail, String duration, String type, double price) {
		super();
		this.name = name;
		this.detail = detail;
		this.duration = duration;
		this.type = type;
		this.price = price;
	}

	public Movie(int mid, String name, String detail, String duration, String type, double price, String comments) {
		super();
		this.mid = mid;
		this.name = name;
		this.detail = detail;
		this.duration = duration;
		this.type = type;
		this.price = price;
		this.comments = comments;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", name=" + name + ", detail=" + detail + ", duration=" + duration + ", type="
				+ type + ", price=" + price + ", comments=" + comments + "]";
	}

}
