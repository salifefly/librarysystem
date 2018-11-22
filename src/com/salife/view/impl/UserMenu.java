package com.salife.view.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.salife.biz.ConsumptionBiz;
import com.salife.biz.MovieBiz;
import com.salife.biz.RechargeBiz;
import com.salife.biz.SessionBiz;
import com.salife.biz.StatisticsBiz;
import com.salife.biz.TicketBiz;
import com.salife.biz.TurnoverBiz;
import com.salife.biz.UserBiz;
import com.salife.biz.impl.ConsumptionBizImpl;
import com.salife.biz.impl.MovieBizImpl;
import com.salife.biz.impl.RechargeBizImpl;
import com.salife.biz.impl.SessionBizImpl;
import com.salife.biz.impl.StatisticsBizImpl;
import com.salife.biz.impl.TicketBizImpl;
import com.salife.biz.impl.TurnoverBizImpl;
import com.salife.biz.impl.UserBizImpl;
import com.salife.entity.Consumption;
import com.salife.entity.Movie;
import com.salife.entity.Recharge;
import com.salife.entity.Session;
import com.salife.entity.Statistics;
import com.salife.entity.Ticket;
import com.salife.entity.User;
import com.salife.util.Util;

public class UserMenu {
	private static int userid = -1;
	private Scanner in = new Scanner(System.in);
	private String choose;
	private UserBiz ub = new UserBizImpl();
	private RechargeBiz rb = new RechargeBizImpl();
	private TicketBiz tb = new TicketBizImpl();
	private MovieBiz mb = new MovieBizImpl();
	private SessionBiz sb = new SessionBizImpl();
	private ConsumptionBiz cob = new ConsumptionBizImpl();
	private StatisticsBiz stb = new StatisticsBizImpl();
	private TurnoverBiz tub = new TurnoverBizImpl();

	public void mainMenu() {
		while (true) {
			System.out.println("====================��ӭʹ��ӰԺ��Ʊϵͳ====================");
			System.out.println("1. ��¼");
			System.out.println("2. ע��");
			System.out.println("0. �˳�");
			choose = in.next();
			switch (choose) {
			case "1":
				logOnMenu();
				break;
			case "2":
				regist();
				break;
			case "0":
				return;
			default:
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}

	}

	public void regist() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫע����˺�");
			String account = in.next();
			if (!ub.findByAccount(account)) {
				System.out.println("��������������");
				String matchstr = "^[a-zA-Z]\\w{5,17}$";
				String string = "����ĸ��ͷ��������6~18֮�䣬ֻ�ܰ����ַ������ֺ��»���";
				String password = Util.nexT(matchstr, string);
				User user = new User(account, password);
				ub.regist(user);
				System.out.println("ע��ɹ�");
			} else {
				System.out.println("������˺��Ѿ����ڣ�ע��ʧ��");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void logOnMenu() {
		while (true) {
			Util.delimiter();
			System.out.println("�����������˺�");
			String account = in.next();
			if (!ub.findByAccount(account)) {
				System.out.println("������˺Ų����ڣ�");
			} else {
				System.out.println("�˺�������ȷ");
				while (true) {
					System.out.println("��������������");
					String password = in.next();
					User user = new User(account, password);
					if (!ub.logonUser(user)) {
						System.out.println("�������");
						if (Util.isGoOn()) {
							continue;
						} else {
							return;
						}
					} else {
						System.out.println("��¼�ɹ�");
						userid = ub.returnUid(user);
						while (true) {
							Util.delimiter();
							System.out.println("��ѡ�����Ĳ���");
							System.out.println("1. �û�������Ϣ");
							System.out.println("2. �����Ӱ");
							System.out.println("3. �鿴������¼");
							System.out.println("0. ������һ��");
							choose = in.next();
							switch (choose) {
							case "1":
								userPersonalInfo();
								break;
							case "2":
								buyMovie();
								break;
							case "3":
								viewRecords();
								break;
							case "0":
								return;
							default:
								System.out.println("��������ȷ��ѡ��");
								break;
							}
						}
					}
				}
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void userPersonalInfo() {
		while (true) {
			Util.delimiter();
			System.out.println("��ѡ�����Ĳ���");
			System.out.println("1. ���Ƹ�����Ϣ");
			System.out.println("2. ��ֵ");
			System.out.println("3. �鿴���");
			System.out.println("4. �鿴��ֵ��Ϣ");
			System.out.println("0. �����ϼ�");
			choose = in.next();
			switch (choose) {
			case "1":
				perfectUserPersonalInfo();
				break;
			case "2":
				recharge();
				break;
			case "3":
				checkBalance();
				break;
			case "4":
				checkRechargeRecord();
				break;
			case "0":
				return;
			default:
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}

	}

	public void perfectUserPersonalInfo() {
		while (true) {
			if (ub.FinishedPerfect(userid)) {
				Util.delimiter();
				ArrayList<User> al = ub.userInfo(userid);
				Util.showArrayList(al, "�û���Ϣ");
			} else {
				Util.delimiter();
				System.out.println("�û���һ�ε�½����������Ϣ");
				System.out.println("������name");
				String name = in.next();
				System.out.println("������sex");
				String sex = in.next();
				System.out.println("������email");
				String matchstr = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
				String string = "�������@����";
				String email = Util.nexT(matchstr, string);
				System.out.println("������phonenumber");
				String phonenumber = in.next();
				ub.updateInfo(userid, name, sex, email, phonenumber);
				System.out.println("���Ƴɹ�");
				ub.setPerfectInfo(userid);
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void recharge() {
		while (true) {
			if (ub.FinishedPerfect(userid)) {
				Util.delimiter();
				System.out.println("��������Ҫ��ֵ�Ľ��");
				double balance = Util.nextdouble();
				if (balance < 0) {
					System.out.println("��ֵʧ�ܣ���������С��0������");
					continue;
				} else {
					int beforevip = ub.returnVip(userid);
					double money = balance;
					double afbalance = ub.recharge(userid, balance);
					Recharge recharge = new Recharge(userid, money);
					rb.recharge(recharge);
					System.out.println("��ֵ�ɹ�");
					double totalrecharge = rb.returnTotalRecharge(userid);
					int vip = 0;
					for (; vip <= 9;) {
						double vipbond = Math.pow(vip, 2) * 100;
						if (vipbond < totalrecharge) {
							vip++;
							continue;
						}
						break;

					}
					ub.setViplevel(userid, vip);
					int aftervip = ub.returnVip(userid);
					System.out.println("�������Ϊ: " + afbalance);
					if (aftervip != beforevip) {
						System.out.println("��������Ϊ" + aftervip + "��vip");
					}
					if (Util.isGoOn()) {
						continue;
					} else {
						return;
					}
				}
			} else {
				Util.delimiter();
				System.out.println("����û������������Ϣ��������������Ϣ���������в���");
				break;
			}
		}

	}

	public void checkBalance() {
		Util.delimiter();
		double balance = ub.returnBalance(userid);
		System.out.println("�����˻����Ϊ:" + balance);
	}

	public void checkRechargeRecord() {
		Util.delimiter();
		ArrayList<Recharge> al = rb.findRechargeByUid(userid);
		Util.showArrayList(al, "�û��ĳ�ֵ��¼");

	}

	public void buyMovie() {
		while (true) {
			Util.delimiter();
			ArrayList<Movie> al = mb.findByAll();
			Util.showArrayList(al, "���е�Ӱ��Ϣ");
			System.out.println("��������Ҫ����ĵ�Ӱmid");
			int mid = Util.nextint();
			System.out.println("��������Ҫ��ȥ�ĵ�ӰԺcid");
			int cid = Util.nextint();
			ArrayList<Session> al2 = sb.findSessionByMidACid(mid, cid);
			Util.showArrayList(al2, "mid��Ӱ��cidӰԺ�ĳ�����Ϣ");
			System.out.println("����������Ҫ���ĳ���hid");
			int hid = Util.nextint();
			ArrayList<Session> al3 = sb.findSessionByMidACidASid(mid, cid, hid);
			Util.showArrayList(al3, "mid��Ӱ��cidӰԺ��hid������Ϣ");
			System.out.println("��ѡ�񳡴�");
			int sid = Util.nextint();
			if (sb.CanBuyTicket(cid, mid, hid, sid)) {
				System.out.println("��ѡ����λ�����£�0Ϊ��ѡ��1Ϊ����ѡ��");
				sb.printSeat(mid, cid, hid, sid);
				System.out.println("����������Ҫ��λ������");
				int row = Util.nextint();
				System.out.println("����������Ҫ��λ������");
				int column = Util.nextint();
				if (sb.getRemain(sid, row, column) == 1) {
					System.out.println("����ѡ�����λ�Ѿ���ѡ����");
					if (Util.isGoOn()) {
						continue;
					} else {
						return;
					}
				} else {
					String seat = row + "," + column;
					int vip = ub.returnVip(userid);
					double discount = ub.discount(vip);
					double price = mb.returnPrice(mid);
					double money = price * discount;
					Statistics statistics = new Statistics(mid, price);
					double balance = ub.returnBalance(userid);
					if (balance >= money) {
						stb.setStatistics(statistics);
						stb.setTotal(mid);
						tub.addTurnover(cid, money);
						String startTime = sb.returnTime(sid);
						String duration = mb.returndurationByMid(mid);
						String overTime = Util.overTime(startTime, duration);
						Ticket ticket = new Ticket(userid, cid, sid, hid, mid, seat, money, startTime, overTime);
						tb.addTicket(ticket);
						String buytime = tb.buyTicket(ticket);
						Consumption consumption = new Consumption(userid, buytime, money);
						cob.addConsumptionOrder(consumption);
						sb.setleftSeatdown(sid);
						sb.setRemain(sid, row, column);
						ub.setBalance(userid, money);
						System.out.println("����ɹ���");
						if (Util.isGoOn()) {
							continue;
						} else {
							return;
						}
					} else {
						System.out.println("�������㣬�����Ƿ��ֵ");
						System.out.println("1. ��");
						System.out.println("2. ��");
						choose = in.next();
						switch (choose) {
						case "1":
							recharge();
							break;
						case "2":
							System.out.println("����ֵ�޷����򣬽��ص���һ������");
							return;
						default:
							System.out.println("��������Զ�Ĭ�ϲ���ֵ");
							return;
						}
					}
				}

			} else {
				System.out.println("������Ҫ�ĳ����Ѿ�û��Ʊ��");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void viewRecords() {
		Util.delimiter();
		ArrayList<Consumption> al = cob.findByUid(userid);
		if (al.size() == 0) {
			System.out.println("û�и��û������Ѽ�¼");
		} else {
			while (true) {
				Util.delimiter();
				System.out.println("����ѡ������Ҫ�Ĳ���");
				System.out.println("1. �鿴δ��ʼ�Ķ���");
				System.out.println("2. �鿴δ��ɵĶ���");
				System.out.println("3. �鿴�Ѿ���ɵĶ���");
				System.out.println("4. �鿴���еĶ���");
				System.out.println("0. �˳�");
				choose = in.next();
				switch (choose) {
				case "1":
					unstartedRecord();
					break;
				case "2":
					unfinishedRecord();
					break;
				case "3":
					finishedRecord();
					break;
				case "4":
					showAllRecord();
					break;
				case "0":
					return;
				default:
					System.out.println("�������");
					break;
				}
			}
		}

	}

	public void unstartedRecord() {
		while (true) {
			Util.delimiter();
			String currentTime = Util.getCurrentTime();
			long currenttime = Util.getLongTime(currentTime);
			ArrayList<Ticket> al = tb.returnStartTime(userid, currenttime);
			Util.showArrayList(al, "��δ��ʼ�Ķ���");
			System.out.println("������Ҫȡ��������");
			System.out.println("1. ��");
			System.out.println("2. ��");
			choose = in.next();
			switch (choose) {
			case "1":
				deleteOrder();
				break;
			case "2":

				return;
			default:
				break;
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}

		}
	}

	public void deleteOrder() {
		while (true) {
			Util.delimiter();
			System.out.println("������tid");
			int tid = Util.nextint();
			long currenttime = System.currentTimeMillis();
			String startTime = tb.returnStartTime(tid);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date start = sdf.parse(startTime);
				long starttime = start.getTime();
				if (starttime - currenttime < 30 * 60 * 1000) {
					System.out.println("������Ʊ");
				} else {
					double refundmoney = tb.returnmoney(tid);
					ub.refundMoney(tid, refundmoney);
					tb.refundTicket(tid);
					System.out.println("��Ʊ�ɹ�");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	public void unfinishedRecord() {
		Util.delimiter();
		String currentTime = Util.getCurrentTime();
		long currenttime = Util.getLongTime(currentTime);
		ArrayList<Ticket> al = tb.returnstartTime(userid, currenttime);
		Util.showArrayList(al, "�Ѿ���ʼ���ǻ�û����ɵĶ���");

	}

	public void finishedRecord() {
		Util.delimiter();
		String currentTime = Util.getCurrentTime();
		long currenttime = Util.getLongTime(currentTime);
		ArrayList<Ticket> al = tb.returnstarttime(userid, currenttime);
		Util.showArrayList(al, "�Ѿ���ɵĶ���");
		ArrayList<Ticket> al2 = tb.unfinishComment(userid,al);
		if (al2.size() != 0) {
			Util.delimiter();
			System.out.println("�����Ѿ���ɵĶ�������δ���۵ĵ�Ӱ");
			System.out.println("�����Ƿ����ۣ�");
			choose = in.next();
			switch (choose) {
			case "y":
				comment();
				break;
			case "n":
				break;
			default:
				break;
			}

		} else {
			System.out.println("û��δ���۵ĵ�Ӱ");
		}

	}

	public void comment() {
		while (true) {
			Util.delimiter();
			String currentTime = Util.getCurrentTime();
			long currenttime = Util.getLongTime(currentTime);
			ArrayList<Ticket> al = tb.returnstarttime(userid, currenttime);
			ArrayList<Ticket> al2 = tb.unfinishComment(userid,al);
			Util.showArrayList(al2, "�Ѿ���ɵ���û�����۵Ķ���");
			System.out.println("��������Ҫ��ɵĵ�Ӱmid");
			int mid = Util.nextint();
			System.out.println("��������Ҫ��ɵĵ�Ӱ������");
			String comment = in.next();
			tb.completeComment(userid, mid, comment);
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void showAllRecord() {
		Util.delimiter();
		ArrayList<Consumption> al = cob.findByUid(userid);
		Util.showArrayList(al, userid + "�����Ѽ�¼");
	}

}
