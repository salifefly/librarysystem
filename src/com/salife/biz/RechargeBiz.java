package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Recharge;

public interface RechargeBiz{
	
	public void recharge(Recharge recharge);
	
	public ArrayList<Recharge> findRechargeByUid(int userid);
	
	public double returnTotalRecharge(int userid);

}
