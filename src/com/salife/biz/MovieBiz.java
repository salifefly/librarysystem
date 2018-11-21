package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Movie;

public interface MovieBiz {
	public void addByName(Movie movie);

	public boolean findByName(String name);

	public ArrayList<Movie> findByAll();

	public ArrayList<Movie> searchByMId(int mid);

	public ArrayList<Movie> searchByName(String name);

	public ArrayList<Movie> searchByType(String type);

	public ArrayList<Movie> searchByPrice(double price);

	public ArrayList<Movie> searchByDuration(String duration);
	
	public double returnPrice(int mid);

	public void deleteMovieByName(String name);

	public boolean findByMId(int mid);

	public void deleteMovieByMId(int mid);

	public void updateMovieByName(Movie movie);

	public String returnNameByMId(int mid);
	
	public String returndurationByMid(int mid);
	
	public int returnMidByName(String name);

}
