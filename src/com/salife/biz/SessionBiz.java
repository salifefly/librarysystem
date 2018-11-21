package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Session;

public interface SessionBiz {
	public boolean confirmSession(Session session);

	public void addSession(Session session);

	public boolean findBySid(int sid);

	public void deleteSessionBySid(int sid);

	public void updateSessionBySid(int sid, String time);

	public ArrayList<Session> findByAll();

	public ArrayList<Session> findSessionBySid(int sid);

	public ArrayList<Session> findSessionByHid(int hid);

	public ArrayList<Session> findSessionByCid(int cid);

	public ArrayList<Session> findSessionByTime(String time);

	public ArrayList<Session> findSessionByMidACid(int mid, int cid);

	public ArrayList<Session> findSessionByMidACidASid(int mid, int cid, int hid);

	public void printSeat(int mid, int cid, int hid, int sid);

	public String returnTime(int sid);

	public void setleftSeatdown(int sid);

	public void setRemain(int sid, int row, int column);

	public int getRemain(int sid, int row, int column);

	public void deleteSessionByMid(int mid);

	public int returnTotalLeftSeat(int mid);

	public ArrayList<Integer> returnSidByMid(int mid);

	public boolean CanBuyTicket(int cid, int mid, int hid, int sid);

}
