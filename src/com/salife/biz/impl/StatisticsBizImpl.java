package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.StatisticsBiz;
import com.salife.dao.StatisticsDao;
import com.salife.dao.impl.StatisticsDaoImpl;
import com.salife.entity.Statistics;

public class StatisticsBizImpl implements StatisticsBiz{
	private StatisticsDao std = new StatisticsDaoImpl();

	@Override
	public void setStatistics(Statistics statistics) {
		std.setStatistics(statistics);
		
	}

	@Override
	public void setTotal(int mid) {
		std.setTotal(mid);
		
	}

	@Override
	public ArrayList<Statistics> checkTurnOver(int mid) {
		
		return std.checkTurnOver(mid);
	}

	@Override
	public void restitution(int mid,int leftseat) {
		std.restitution(mid,leftseat);
		
	}
}
