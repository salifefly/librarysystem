package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.MovieBiz;
import com.salife.dao.MovieDao;
import com.salife.dao.impl.MovieDaoImpl;
import com.salife.entity.Movie;

public class MovieBizImpl implements MovieBiz {
	private MovieDao md = new MovieDaoImpl();

	@Override
	public void addByName(Movie movie) {
		md.addByName(movie);
	}

	@Override
	public boolean findByName(String name) {
		if(md.findByName(name)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Movie> findByAll() {
		ArrayList<Movie> al = md.findByAll();
		return al;
	}

	@Override
	public void deleteMovieByName(String name) {
		md.deleteMovieByName(name);
		
	}

	@Override
	public boolean findByMId(int mid) {
		if(md.findByMId(mid)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteMovieByMId(int mid) {
		md.deleteMovieByMId(mid);
		
	}

	@Override
	public void updateMovieByName(Movie movie) {
		md.updateMovieByName(movie);
	}

	@Override
	public String returnNameByMId(int mid) {
		String name = md.returnNameByMId(mid);
		return name;
	}

	@Override
	public ArrayList<Movie> searchByMId(int mid) {
		ArrayList<Movie> al = md.searchByMId(mid);
		return al;
	}

	@Override
	public ArrayList<Movie> searchByName(String name) {
		ArrayList<Movie> al = md.searchByName(name);
		return al;
	}

	@Override
	public ArrayList<Movie> searchByType(String type) {
		ArrayList<Movie> al = md.searchByType(type);
		return al;
	}

	@Override
	public ArrayList<Movie> searchByPrice(double price) {
		ArrayList<Movie> al = md.searchByPrice(price);
		return al;
	}

	@Override
	public ArrayList<Movie> searchByDuration(String duration) {
		ArrayList<Movie> al = md.searchByDuration(duration);
		return al;
	}

	@Override
	public double returnPrice(int mid) {
		
		return md.returnPrice(mid);
	}

	@Override
	public String returndurationByMid(int mid) {

		return md.returndurationByMid(mid);
	}

	@Override
	public int returnMidByName(String name) {
		
		return md.returnMidByName(name);
	}
}
