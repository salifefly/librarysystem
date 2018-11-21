package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Consumption;

public interface ConsumptionBiz {
	
	public void addConsumptionOrder(Consumption consumption);
	
	public ArrayList<Consumption> findByUid(int userid);
	
	public double returnBackMoney(ArrayList<Integer> al2);
	
	public void deleteCon(ArrayList<Integer> al2);
	
	public ArrayList<Double> returnUidMoney(ArrayList<Integer> al2);

}
