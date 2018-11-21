package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.SessionBiz;
import com.salife.dao.HallDao;
import com.salife.dao.MovieDao;
import com.salife.dao.SessionDao;
import com.salife.dao.impl.HallDaoImpl;
import com.salife.dao.impl.MovieDaoImpl;
import com.salife.dao.impl.SessionDaoImpl;
import com.salife.entity.Session;

public class SessionBizImpl implements SessionBiz {
	private SessionDao sd = new SessionDaoImpl();
	private MovieDao md = new MovieDaoImpl();
	private HallDao hd = new HallDaoImpl();

	@Override
	public boolean confirmSession(Session session) {
		if (sd.confirmSession(session) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void addSession(Session session) {
		double price = md.findByMId(session.getMid()).getPrice();
		int remain = hd.findByHid(session.getHid()).getCapacity();
		sd.addSession(session, remain, price);

	}

	@Override
	public boolean findBySid(int sid) {
		if (sd.findBySid(sid) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteSessionBySid(int sid) {
		sd.deleteSessionBySid(sid);

	}

	@Override
	public void updateSessionBySid(int sid, String time) {
		sd.updateSessionBySid(sid, time);

	}

	@Override
	public ArrayList<Session> findByAll() {
		return sd.findByAll();
	}

	@Override
	public ArrayList<Session> findSessionBySid(int sid) {
		return sd.findSessionBySid(sid);
	}

	@Override
	public ArrayList<Session> findSessionByHid(int hid) {

		return sd.findSessionByHid(hid);
	}

	@Override
	public ArrayList<Session> findSessionByCid(int cid) {

		return sd.findSessionByCid(cid);
	}

	@Override
	public ArrayList<Session> findSessionByTime(String time) {

		return sd.findSessionByTime(time);
	}

	public ArrayList<Session> findSessionByMidACid(int mid, int cid) {

		return sd.findSessionByMidACid(mid, cid);
	}

	@Override
	public ArrayList<Session> findSessionByMidACidASid(int mid, int cid, int hid) {
		ArrayList<Session> al = sd.findSessionByMidACid(mid, cid);
		ArrayList<Session> al2 = new ArrayList<Session>();
		for (int i = 0; i < al.size(); i++) {
			if (hid == al.get(i).getHid()) {
				al2.add(al.get(i));
			}
		}
		return al2;
	}

	@Override
	public void printSeat(int mid, int cid, int hid, int sid) {
		sd.printSeat(mid, cid, hid, sid);

	}

	@Override
	public String returnTime(int sid) {

		return sd.returnTime(sid);
	}

	@Override
	public void setleftSeatdown(int sid) {
		sd.setleftSeatdown(sid);

	}

	@Override
	public void setRemain(int sid, int row, int column) {
		sd.setRemain(sid, row, column);

	}

	public int getRemain(int sid, int row, int column) {
		return sd.getRemain(sid, row, column);

	}

	@Override
	public void deleteSessionByMid(int mid) {
		sd.deleteSessionByMid(mid);

	}

	@Override
	public int returnTotalLeftSeat(int mid) {

		return sd.returnTotalLeftSeat(mid);
	}

	@Override
	public ArrayList<Integer> returnSidByMid(int mid) {

		return sd.returnSidByMid(mid);
	}

	@Override
	public boolean CanBuyTicket(int cid, int mid, int hid, int sid) {
		if (sd.CanBuyTicket(cid, mid, hid, sid)) {
			return true;
		}
		return false;
	}
}
