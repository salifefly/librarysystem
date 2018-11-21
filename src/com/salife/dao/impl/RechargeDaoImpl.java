package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.RechargeDao;
import com.salife.entity.Recharge;

public class RechargeDaoImpl extends BaseDao implements RechargeDao {
	private ArrayList<Recharge> al;
	
	public RechargeDaoImpl() {
		file = new File("Recharge.txt");
	}

	@Override
	public void recharge(Recharge recharge) {
		al = read();
		al.add(recharge);
		write(al);

	}

	@Override
	public ArrayList<Recharge> findRechargeByUid(int userid) {
		al = read();
		ArrayList<Recharge> al2 = new ArrayList<Recharge>();
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				al2.add(al.get(i));
			}
		}
		return al2;
	}

	@Override
	public double returnTotalRecharge(int userid) {
		al = read();
		double totalRecharge = 0;
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				totalRecharge += al.get(i).getMoney();
			}
		}
		return totalRecharge;
	}

}
