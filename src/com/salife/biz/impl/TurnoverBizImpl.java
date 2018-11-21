package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.TurnoverBiz;
import com.salife.dao.TurnoverDao;
import com.salife.dao.impl.TurnoverDaoImpl;
import com.salife.entity.Turnover;

public class TurnoverBizImpl implements TurnoverBiz {

	private TurnoverDao tud = new TurnoverDaoImpl();

	@Override
	public void addTurnover(int cid, double money) {
		tud.addTurnover(cid, money);

	}

	@Override
	public ArrayList<Turnover> checkTurnover(int cid) {

		return tud.checkTurnover(cid);
	}

	@Override
	public void setTurnover(int admincid, double backmoney) {
		tud.setTurnover(admincid, backmoney);

	}

}
