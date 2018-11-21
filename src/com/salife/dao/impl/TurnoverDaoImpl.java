package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.TurnoverDao;
import com.salife.entity.Turnover;

public class TurnoverDaoImpl extends BaseDao implements TurnoverDao {
	private ArrayList<Turnover> al;

	public TurnoverDaoImpl() {
		file = new File("Turnover.txt");
	}

	@Override
	public void addTurnover(int cid, double money) {
		al = read();
		if (al.contains(new Turnover(cid))) {
			for (int i = 0; i < al.size(); i++) {
				if (cid == al.get(i).getCid()) {
					al.get(i).setTurnoverpd(al.get(i).getTurnoverpd() + money);
					break;
				}
			}
		} else {
			al.add(new Turnover(cid, money));
		}
		write(al);

	}

	@Override
	public ArrayList<Turnover> checkTurnover(int cid) {
		al = read();
		ArrayList<Turnover> al2 = new ArrayList<Turnover>();
		for (int i = 0; i < al.size(); i++) {
			if (cid == al.get(i).getCid()) {
				al2.add(al.get(i));
			}
		}
		return al2;
	}

	@Override
	public void setTurnover(int admincid,double backmoney) {
		al = read();
		for(int i = 0;i<al.size();i++) {
			if(admincid == al.get(i).getCid()) {
				al.get(i).setTurnoverpd(al.get(i).getTurnoverpd()-backmoney);
				System.out.println(al.get(i).getTurnoverpd());
				System.out.println(backmoney);
			}
		}
		write(al);
	}
}
