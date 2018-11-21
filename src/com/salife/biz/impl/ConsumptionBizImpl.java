package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.ConsumptionBiz;
import com.salife.dao.ConsumptionDao;
import com.salife.dao.impl.ConsumptionDaoImpl;
import com.salife.entity.Consumption;

public class ConsumptionBizImpl implements ConsumptionBiz {
	private ConsumptionDao cod = new ConsumptionDaoImpl();

	@Override
	public void addConsumptionOrder(Consumption consumption) {
		cod.addConsumptionOrder(consumption);
		
	}

	@Override
	public ArrayList<Consumption> findByUid(int userid) {

		return cod.findByUid(userid);
	}

	@Override
	public double returnBackMoney(ArrayList<Integer> al2) {

		return cod.returnBackMoney(al2);
	}
	
	public void deleteCon(ArrayList<Integer> al2) {
		
		cod.deleteCon(al2);
	}

	@Override
	public ArrayList<Double> returnUidMoney(ArrayList<Integer> al2) {
		
		return cod.returnUidMoney(al2);
	}

	
}
