package com.salife.biz.impl;

import java.util.ArrayList;

import com.salife.biz.TicketBiz;
import com.salife.dao.TicketDao;
import com.salife.dao.impl.TicketDaoImpl;
import com.salife.entity.Ticket;

public class TicketBizImpl implements TicketBiz {
	private TicketDao td = new TicketDaoImpl();

	@Override
	public String buyTicket(Ticket ticket) {
		return td.buyTicket(ticket);

	}

	@Override
	public void addTicket(Ticket ticket) {
		td.addTicket(ticket);

	}

	@Override
	public ArrayList<Ticket> returnStartTime(int userid, long currenttime) {

		return td.returnStartTime(userid, currenttime);
	}

	@Override
	public ArrayList<Ticket> returnstartTime(int userid, long currenttime) {

		return td.returnstartTime(userid, currenttime);
	}

	@Override
	public ArrayList<Ticket> returnstarttime(int userid, long currenttime) {

		return td.returnstarttime(userid, currenttime);
	}

	@Override
	public ArrayList<Ticket> unfinishComment(int userid,ArrayList<Ticket> al) {

		return td.unfinishComment(userid,al);
	}

	@Override
	public void completeComment(int userid, int mid, String comment) {
		td.completeComment(userid, mid, comment);

	}

	@Override
	public void deleteTicketByMid(int mid) {
		td.deleteTicketByMid(mid);
		
	}

	@Override
	public ArrayList<Integer> returnUidByMid(int mid) {
		
		return td.returnUidByMid(mid);
	}

	@Override
	public String returnStartTime(int tid) {
		
		return td.returnStartTime(tid);
	}

	@Override
	public void refundTicket(int tid) {
		td.refundTicket(tid);
		
	}

	@Override
	public double returnmoney(int tid) {
		
		return td.returnmoney(tid);
	}
}
