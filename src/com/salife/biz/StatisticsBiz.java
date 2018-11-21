package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Statistics;

public interface StatisticsBiz {
	public void setStatistics(Statistics statistics);
	
	public void setTotal(int mid);
	
	public ArrayList<Statistics> checkTurnOver(int mid);
	
	public void restitution(int mid,int leftseat);
}
