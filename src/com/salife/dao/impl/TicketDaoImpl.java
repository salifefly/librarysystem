package com.salife.dao.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.salife.dao.TicketDao;
import com.salife.entity.Ticket;
import com.salife.util.Util;

public class TicketDaoImpl extends BaseDao implements TicketDao {
	private ArrayList<Ticket> al;

	public TicketDaoImpl() {
		file = new File("Ticket.txt");
	}

	@Override
	public void buyTicket(int uid) {
		al = read();
	}

	@Override
	public String buyTicket(Ticket ticket) {
		Date buyTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String buytime = df.format(buyTime);
		return buytime;

	}

	@Override
	public void addTicket(Ticket ticket) {
		al = read();
		if (al.size() == 0) {
			ticket.setTid(1);
		} else {
			ticket.setTid(al.get(al.size() - 1).getTid() + 1);
		}
		al.add(ticket);
		write(al);
	}

	@Override
	public ArrayList<Ticket> returnStartTime(int userid, long currenttime) {
		al = read();
		ArrayList<Ticket> al2 = new ArrayList<Ticket>();
		String startTime = null;
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				startTime = al.get(i).getStartTime();
				long starttime = Util.getLongTime(startTime);
				if (currenttime <= starttime) {
					al2.add(al.get(i));
				}
			}
		}
		return al2;
	}

	@Override
	public ArrayList<Ticket> returnstartTime(int userid, long currenttime) {
		al = read();
		ArrayList<Ticket> al2 = new ArrayList<Ticket>();
		String startTime = null;
		String overTime = null;
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				startTime = al.get(i).getStartTime();
				long starttime = Util.getLongTime(startTime);
				overTime = al.get(i).getOverTime();
				long overtime = Util.getLongTime(overTime);
				if (currenttime >= starttime && currenttime < overtime) {
					al2.add(al.get(i));
				}
			}
		}
		return al2;
	}

	@Override
	public ArrayList<Ticket> returnstarttime(int userid, long currenttime) {
		al = read();
		ArrayList<Ticket> al2 = new ArrayList<Ticket>();
		String overTime = null;
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid()) {
				overTime = al.get(i).getOverTime();
				long overtime = Util.getLongTime(overTime);
				if (currenttime >= overtime) {
					al2.add(al.get(i));
				}
			}
		}
		return al2;
	}

	@Override
	public ArrayList<Ticket> unfinishComment(int userid,ArrayList<Ticket> al) {
		ArrayList<Ticket> al2 = new ArrayList<Ticket>();
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid() && al.get(i).getComments() == null) {
				al2.add(al.get(i));
			}
		}
		return al2;
	}

	@Override
	public void completeComment(int userid, int mid, String comment) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (userid == al.get(i).getUid() && mid == al.get(i).getMid() && al.get(i).getComments() == null) {
				al.get(i).setComments(comment);
				break;
			}
		}
		write(al);

	}

	@Override
	public void deleteTicketByMid(int mid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (mid == al.get(i).getMid()) {
				al.remove(i);
			}
		}
		write(al);

	}

	@Override
	public ArrayList<Integer> returnUidByMid(int mid) {
		al = read();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		for (int i = 0; i < al.size(); i++) {
			if (mid == al.get(i).getMid()) {
				if (!al2.contains(al.get(i).getUid())) {
					al2.add(al.get(i).getUid());
				}
			}
		}
		return al2;
	}

	@Override
	public String returnStartTime(int tid) {
		al = read();
		String startTime = null;
		for (int i = 0; i < al.size(); i++) {
			if (tid == al.get(i).getTid()) {
				startTime = al.get(i).getStartTime();
				break;
			}
		}
		return startTime;
	}

	@Override
	public void refundTicket(int tid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (tid == al.get(i).getTid()) {
				al.remove(i);
			}
		}
		write(al);
	}

	@Override
	public double returnmoney(int tid) {
		al = read();
		double money = 0;
		for (int i = 0; i < al.size(); i++) {
			if (tid == al.get(i).getTid()) {
				money = al.get(i).getPrice();
				break;
			}
		}
		return money;
	}
}
