package com.salife.dao;

import java.util.ArrayList;

import com.salife.entity.Turnover;

public interface TurnoverDao {
	public void addTurnover(int cid, double money);

	public ArrayList<Turnover> checkTurnover(int cid);

	public void setTurnover(int admincid, double backmoney);

}
