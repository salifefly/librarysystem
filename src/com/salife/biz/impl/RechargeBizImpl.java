package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.RechargeBiz;
import com.salife.dao.RechargeDao;
import com.salife.dao.impl.RechargeDaoImpl;
import com.salife.entity.Recharge;

public class RechargeBizImpl implements RechargeBiz {
	private RechargeDao rd = new RechargeDaoImpl();

	@Override
	public void recharge(Recharge recharge) {
		rd.recharge(recharge);
		
	}

	@Override
	public ArrayList<Recharge> findRechargeByUid(int userid) {
		
		return rd.findRechargeByUid(userid);
	}

	@Override
	public double returnTotalRecharge(int userid) {
		
		return rd.returnTotalRecharge(userid);
	}

}
