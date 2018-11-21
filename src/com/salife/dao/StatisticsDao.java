package com.salife.dao;

import java.util.ArrayList;

import com.salife.entity.Statistics;

public interface StatisticsDao {

	public void setStatistics(Statistics statistics);
	
	public void setTotal(int mid);
	
	public ArrayList<Statistics> checkTurnOver(int mid);
	
	public void restitution(int mid,int leftseat);

}
