package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Turnover;

public interface TurnoverBiz {
	public void addTurnover(int cid,double money);
	
	public ArrayList<Turnover> checkTurnover(int cid);
	
	public void setTurnover(int admincid,double backmoney);
}
