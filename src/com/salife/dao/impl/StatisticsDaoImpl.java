package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.StatisticsDao;
import com.salife.entity.Statistics;

public class StatisticsDaoImpl extends BaseDao implements StatisticsDao {
	private ArrayList<Statistics> al;

	public StatisticsDaoImpl() {
		file = new File("Statistics.txt");
	}

	@Override
	public void setStatistics(Statistics statistics) {
		al = read();
		if(al.contains(statistics)) {
			for(int i = 0;i<al.size();i++) {
				if(statistics.getMid()==al.get(i).getMid()) {
					al.get(i).setNumber(al.get(i).getNumber()+1);
				}
			}
		}else {
			al.add(statistics);
		}
		write(al);
	}

	@Override
	public void setTotal(int mid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if(mid == al.get(i).getMid()) {
				al.get(i).setTotalmovieprice(al.get(i).getPrice()*al.get(i).getNumber());
				break;
			}
		}
		write(al);
	}

	@Override
	public ArrayList<Statistics> checkTurnOver(int mid) {
		al = read();
		ArrayList<Statistics> al2 = new ArrayList<Statistics>();
		for(int i = 0;i<al.size();i++) {
			if(mid == al.get(i).getMid()) {
				al2.add(al.get(i));
			}
		}
		return al2;
	}

	@Override
	public void restitution(int mid,int leftseat) {
		al = read();
		for(int i = 0;i<al.size();i++) {
			if(mid == al.get(i).getMid()) {
				al.get(i).setNumber(al.get(i).getNumber()-leftseat);
				al.get(i).setTotalmovieprice(al.get(i).getPrice()*al.get(i).getNumber());
			}
		}
		write(al);
		
	}
}
