package com.salife.dao;

import java.util.ArrayList;

import com.salife.entity.Movie;

public interface MovieDao {
	public Movie findByName(String name);

	public ArrayList<Movie> searchByMId(int mid);

	public ArrayList<Movie> searchByName(String name);

	public ArrayList<Movie> searchByType(String type);

	public ArrayList<Movie> searchByPrice(double price);

	public ArrayList<Movie> searchByDuration(String duration);

	public void addByName(Movie movie);

	public ArrayList<Movie> findByAll();

	public void deleteMovieByName(String name);

	public Movie findByMId(int mid);

	public void deleteMovieByMId(int mid);

	public void updateMovieByName(Movie movie);

	public String returnNameByMId(int mid);
	
	public double returnPrice(int mid);
	
	public String returndurationByMid(int mid);
	
	public int returnMidByName(String name);

}
