package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.MovieDao;
import com.salife.entity.Movie;

public class MovieDaoImpl extends BaseDao implements MovieDao {
	private ArrayList<Movie> al;

	public MovieDaoImpl() {
		file = new File("Movie.txt");
	}

	@Override
	public Movie findByName(String name) {
		al = read();
		Movie movie = null;
		for (int i = 0; i < al.size(); i++) {
			if (name.equals(al.get(i).getName())) {
				movie = al.get(i);
			}
		}
		return movie;
	}

	@Override
	public void addByName(Movie movie) {
		al = read();
		if (al.size() == 0) {
			movie.setMid(1);
		} else {
			movie.setMid(al.get(al.size() - 1).getMid() + 1);
		}
		al.add(movie);
		write(al);
	}

	@Override
	public ArrayList<Movie> findByAll() {
		al = read();
		return al;
	}

	@Override
	public void deleteMovieByName(String name) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (name.equals(al.get(i).getName())) {
				al.remove(i);
			}
		}
		write(al);

	}

	@Override
	public Movie findByMId(int mid) {
		al = read();
		Movie movie = null;
		for (int i = 0; i < al.size(); i++) {
			if (mid == al.get(i).getMid()) {
				movie = al.get(i);
				break;
			}
		}
		return movie;
	}

	@Override
	public void deleteMovieByMId(int mid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if(mid==al.get(i).getMid()) {
				al.remove(i);
				break;
			}
		}
		write(al);
	}

	@Override
	public void updateMovieByName(Movie movie) {//这个是三层架构吗
		al = read();
		for(int i = 0;i<al.size();i++) {
			if(movie.getName().equals(al.get(i).getName())) {
				al.set(i, movie);
				break;
			}
		}
		write(al);
		
	}

	@Override
	public String returnNameByMId(int mid) {
		al = read();
		String name = null;
		for(int i = 0;i<al.size();i++) {
			if(mid == al.get(i).getMid()) {
				name = al.get(i).getName();
			}
		}
		return name;
	}

	@Override
	public ArrayList<Movie> searchByMId(int mid) {
		al = read();
		ArrayList<Movie> al1 = new ArrayList<Movie>();
		for(int i = 0;i<al.size();i++) {
			if(mid==al.get(i).getMid()) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public ArrayList<Movie> searchByName(String name) {
		al = read();
		ArrayList<Movie> al1 = new ArrayList<Movie>();
		for(int i = 0;i<al.size();i++) {
			if(name.equals(al.get(i).getName())) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public ArrayList<Movie> searchByType(String type) {
		al = read();
		ArrayList<Movie> al1 = new ArrayList<Movie>();
		for(int i = 0;i<al.size();i++) {
			if(type.equals(al.get(i).getType())) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public ArrayList<Movie> searchByPrice(double price) {
		al = read();
		ArrayList<Movie> al1 = new ArrayList<Movie>();
		for(int i = 0;i<al.size();i++) {
			if(price<=al.get(i).getPrice()) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public ArrayList<Movie> searchByDuration(String duration) {
		al = read();
		ArrayList<Movie> al1 = new ArrayList<Movie>();
		for(int i = 0;i<al.size();i++) {
			if(duration.equals(al.get(i).getDuration())) {
				al1.add(al.get(i));
			}
		}
		return al1;
	}

	@Override
	public double returnPrice(int mid) {
		al = read();
		double price = 0;
		for(int i = 0;i<al.size();i++) {
			if(mid == al.get(i).getMid()) {
				price = al.get(i).getPrice();
				break;
			}
		}
		return price;
	}

	@Override
	public String returndurationByMid(int mid) {
		al = read();
		String duration = null;
		for(int i = 0;i<al.size();i++) {
			if(mid == al.get(i).getMid()) {
				duration = al.get(i).getDuration();
			}
		}
		return duration;
	}

	@Override
	public int returnMidByName(String name) {
		al =read();
		int mid = -1;
		for(int i = 0;i<al.size();i++) {
			if(name.equals(al.get(i).getName())) {
				mid = al.get(i).getMid();
			}
		}
		return mid;
	}
}
