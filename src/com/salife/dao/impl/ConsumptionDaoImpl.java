package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.ConsumptionDao;
import com.salife.entity.Consumption;

public class ConsumptionDaoImpl extends BaseDao implements ConsumptionDao{
	private ArrayList<Consumption> al;
	
	public ConsumptionDaoImpl() {
		file = new File("Consumption.txt");
	}

	@Override
	public void addConsumptionOrder(Consumption consumption) {
		al = read();
		if(al.size()==0) {
			consumption.setConid(1);
		}else {
			consumption.setConid(al.get(al.size()-1).getUid()+1);
		}
		al.add(consumption);
		write(al);
	}

	@Override
	public ArrayList<Consumption> findByUid(int userid) {
		al = read();
		ArrayList<Consumption> al2 = new ArrayList<Consumption>();
		for(int i = 0;i<al.size();i++) {
			if(userid == al.get(i).getUid()) {
				al2.add(al.get(i));
			}
		}
		return al2;
	}

	@Override
	public double returnBackMoney(ArrayList<Integer> al2) {
		al = read();
		double backmoney = 0;
		for(int i = 0;i<al.size();i++) {
			if(al2.contains(al.get(i).getUid())) {
				backmoney+=al.get(i).getMoney();
			}
		}
		return backmoney;
	}
	
	public void deleteCon(ArrayList<Integer> al2) {
		al = read();
		for(int i = al.size()-1;i>=0;i--) {
			if(al2.contains(al.get(i).getUid())) {
				al.remove(i);
			}
		}
		write(al);
	}

	@Override
	public ArrayList<Double> returnUidMoney(ArrayList<Integer> al2) {
		al = read();
		ArrayList<Double> al3 = new ArrayList<Double>();
		for(int i = 0;i<al2.size();i++) {
			double money = 0;
			for(int k = 0;k<al.size();k++) {
				if(al2.get(i)==al.get(i).getUid()) {
					money+=al.get(i).getMoney();
				}
			}
			al3.add(money);
		}
		return al3;
	}
}
