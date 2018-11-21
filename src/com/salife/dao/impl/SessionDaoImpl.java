package com.salife.dao.impl;

import java.io.File;
import java.util.ArrayList;

import com.salife.dao.SessionDao;
import com.salife.entity.Session;

public class SessionDaoImpl extends BaseDao implements SessionDao {
	private ArrayList<Session> al;

	public SessionDaoImpl() {
		file = new File("Session.txt");
	}

	@Override
	public Session confirmSession(Session session) {
		al = read();
		Session session2 = null;
		for (int i = 0; i < al.size(); i++) {
			if (session.getCid() == al.get(i).getCid() && session.getHid() == al.get(i).getHid()
					&& session.getMid() == al.get(i).getMid() && session.getPrice() == al.get(i).getPrice()) {
				session2 = al.get(i);
				break;
			}
		}
		return session2;
	}

	@Override
	public void addSession(Session session, int remain, double price) {
		al = read();
		if (al.size() == 0) {
			session.setSid(1);
		} else {
			session.setSid(al.get(al.size() - 1).getSid() + 1);
		}
		session.setLeftseat(remain);
		session.setPrice(price);
		al.add(session);
		write(al);
	}

	@Override
	public Session findBySid(int sid) {
		al = read();
		Session session = null;
		for (int i = 0; i < al.size(); i++) {
			if (sid == al.get(i).getSid()) {
				session = al.get(i);
				break;
			}
		}
		return session;
	}

	@Override
	public void deleteSessionBySid(int sid) {
		al = read();
		for (int index = 0; index < al.size(); index++) {
			if (sid == al.get(index).getSid()) {
				al.remove(index);
			}
		}
		write(al);

	}

	@Override
	public void updateSessionBySid(int sid, String time) {
		al = read();
		for (int index = 0; index < al.size(); index++) {
			if (sid == al.get(index).getSid()) {
				al.get(index).setTime(time);
				break;
			}
		}
		write(al);

	}

	@Override
	public ArrayList<Session> findByAll() {
		al = read();
		return al;
	}

	@Override
	public ArrayList<Session> findSessionBySid(int sid) {
		al = read();
		ArrayList<Session> al2 = new ArrayList<Session>();
		for (int index = 0; index < al.size(); index++) {
			if (sid == al.get(index).getSid()) {
				al2.add(al.get(index));
			}
		}
		return al2;
	}

	@Override
	public ArrayList<Session> findSessionByHid(int hid) {
		al = read();
		ArrayList<Session> al2 = new ArrayList<Session>();
		for (int index = 0; index < al.size(); index++) {
			if (hid == al.get(index).getHid()) {
				al2.add(al.get(index));
			}
		}
		return al2;
	}

	@Override
	public ArrayList<Session> findSessionByCid(int cid) {
		al = read();
		ArrayList<Session> al2 = new ArrayList<Session>();
		for (int index = 0; index < al.size(); index++) {
			if (cid == al.get(index).getCid()) {
				al2.add(al.get(index));
			}
		}
		return al2;
	}

	@Override
	public ArrayList<Session> findSessionByTime(String time) {
		al = read();
		ArrayList<Session> al2 = new ArrayList<Session>();
		for (int index = 0; index < al.size(); index++) {
			if (time.equals(al.get(index).getTime())) {
				al2.add(al.get(index));
			}
		}
		return al2;
	}

	@Override
	public ArrayList<Session> findSessionByMidACid(int mid, int cid) {
		al = read();
		ArrayList<Session> al2 = new ArrayList<Session>();
		for (int index = 0; index < al.size(); index++) {
			if (mid == al.get(index).getMid() && cid == al.get(index).getCid()) {
				al2.add(al.get(index));
			}
		}
		return al2;
	}

	@Override
	public void printSeat(int mid, int cid, int hid, int sid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (mid == al.get(i).getMid() && cid == al.get(i).getCid() && hid == al.get(i).getHid()
					&& sid == al.get(i).getSid()) {
				int[][] seat = al.get(i).getRemain();
				for (int j = 0; j < seat.length; j++) {
					for (int k = 0; k < seat[j].length; k++) {
						System.out.print(seat[j][k] + "   ");
					}
					System.out.println();
				}
				break;
			}
		}

	}

	@Override
	public String returnTime(int sid) {
		al = read();
		String startTime = null;
		for (int i = 0; i < al.size(); i++) {
			if (sid == al.get(i).getSid()) {
				startTime = al.get(i).getTime();
			}
		}
		return startTime;
	}

	@Override
	public void setleftSeatdown(int sid) {
		al = read();
		int leftSeat = 0;
		for (int i = 0; i < al.size(); i++) {
			if (sid == al.get(i).getSid()) {
				leftSeat = al.get(i).getLeftseat() - 1;
				al.get(i).setLeftseat(leftSeat);
			}
		}
		write(al);

	}

	@Override
	public void setRemain(int sid, int row, int column) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (sid == al.get(i).getSid()) {
				al.get(i).getRemain()[row][column] = 1;
				break;
			}
		}
		write(al);
	}

	public int getRemain(int sid, int row, int column) {
		al = read();
		int remainseat = -1;
		for (int i = 0; i < al.size(); i++) {
			if (sid == al.get(i).getSid()) {
				remainseat = al.get(i).getRemain()[row][column];
				break;
			}
		}
		return remainseat;

	}

	@Override
	public void deleteSessionByMid(int mid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (mid == al.get(i).getMid()) {
				al.remove(i);
			}
		}
		write(al);

	}

	@Override
	public int returnTotalLeftSeat(int mid) {
		al = read();
		int totalleft = 0;
		for (int i = 0; i < al.size(); i++) {
			if (mid == al.get(i).getMid()) {
				totalleft += (40 - al.get(i).getLeftseat());
			}
		}
		return totalleft;
	}

	@Override
	public ArrayList<Integer> returnSidByMid(int mid) {
		al = read();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		for (int i = 0; i < al.size(); i++) {
			if (mid == al.get(i).getMid()) {
				al2.add(al.get(i).getSid());
			}
		}
		return al2;
	}

	@Override
	public boolean CanBuyTicket(int cid, int mid, int hid, int sid) {
		al = read();
		for (int i = 0; i < al.size(); i++) {
			if (cid == al.get(i).getCid() && mid == al.get(i).getMid() && hid == al.get(i).getHid()
					&& sid == al.get(i).getSid()) {
				if (al.get(i).getLeftseat() > 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
