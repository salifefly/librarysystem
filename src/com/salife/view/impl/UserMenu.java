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
			System.out.println("====================欢迎使用影院售票系统====================");
			System.out.println("1. 登录");
			System.out.println("2. 注册");
			System.out.println("0. 退出");
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
				System.out.println("请输入正确的选择");
				break;
			}
		}

	}

	public void regist() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要注册的账号");
			String account = in.next();
			if (!ub.findByAccount(account)) {
				System.out.println("请输入您的密码");
				String matchstr = "^[a-zA-Z]\\w{5,17}$";
				String string = "以字母开头，长度在6~18之间，只能包含字符、数字和下划线";
				String password = Util.nexT(matchstr, string);
				User user = new User(account, password);
				ub.regist(user);
				System.out.println("注册成功");
			} else {
				System.out.println("输入的账号已经存在，注册失败");
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
			System.out.println("请输入您的账号");
			String account = in.next();
			if (!ub.findByAccount(account)) {
				System.out.println("输入的账号不存在！");
			} else {
				System.out.println("账号输入正确");
				while (true) {
					System.out.println("请输入您的密码");
					String password = in.next();
					User user = new User(account, password);
					if (!ub.logonUser(user)) {
						System.out.println("密码错误");
						if (Util.isGoOn()) {
							continue;
						} else {
							return;
						}
					} else {
						System.out.println("登录成功");
						userid = ub.returnUid(user);
						while (true) {
							Util.delimiter();
							System.out.println("请选择您的操作");
							System.out.println("1. 用户个人信息");
							System.out.println("2. 购买电影");
							System.out.println("3. 查看订单记录");
							System.out.println("0. 返回上一级");
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
								System.out.println("请输入正确的选择");
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
			System.out.println("请选择您的操作");
			System.out.println("1. 完善个人信息");
			System.out.println("2. 充值");
			System.out.println("3. 查看余额");
			System.out.println("4. 查看充值信息");
			System.out.println("0. 返回上级");
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
				System.out.println("请输入正确的选择");
				break;
			}
		}

	}

	public void perfectUserPersonalInfo() {
		while (true) {
			if (ub.FinishedPerfect(userid)) {
				Util.delimiter();
				ArrayList<User> al = ub.userInfo(userid);
				Util.showArrayList(al, "用户信息");
			} else {
				Util.delimiter();
				System.out.println("用户第一次登陆，请完善信息");
				System.out.println("请输入name");
				String name = in.next();
				System.out.println("请输入sex");
				String sex = in.next();
				System.out.println("请输入email");
				String matchstr = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
				String string = "必须带有@符号";
				String email = Util.nexT(matchstr, string);
				System.out.println("请输入phonenumber");
				String phonenumber = in.next();
				ub.updateInfo(userid, name, sex, email, phonenumber);
				System.out.println("完善成功");
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
				System.out.println("请输入您要充值的金额");
				double balance = Util.nextdouble();
				if (balance < 0) {
					System.out.println("充值失败，不能输入小于0的数字");
					continue;
				} else {
					int beforevip = ub.returnVip(userid);
					double money = balance;
					double afbalance = ub.recharge(userid, balance);
					Recharge recharge = new Recharge(userid, money);
					rb.recharge(recharge);
					System.out.println("充值成功");
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
					System.out.println("您的余额为: " + afbalance);
					if (aftervip != beforevip) {
						System.out.println("您已升级为" + aftervip + "级vip");
					}
					if (Util.isGoOn()) {
						continue;
					} else {
						return;
					}
				}
			} else {
				Util.delimiter();
				System.out.println("您还没有完善您的信息，请完善您的信息后再来进行操作");
				break;
			}
		}

	}

	public void checkBalance() {
		Util.delimiter();
		double balance = ub.returnBalance(userid);
		System.out.println("您的账户余额为:" + balance);
	}

	public void checkRechargeRecord() {
		Util.delimiter();
		ArrayList<Recharge> al = rb.findRechargeByUid(userid);
		Util.showArrayList(al, "用户的充值记录");

	}

	public void buyMovie() {
		while (true) {
			Util.delimiter();
			ArrayList<Movie> al = mb.findByAll();
			Util.showArrayList(al, "所有电影信息");
			System.out.println("请输入您要购买的电影mid");
			int mid = Util.nextint();
			System.out.println("请输入您要想去的电影院cid");
			int cid = Util.nextint();
			ArrayList<Session> al2 = sb.findSessionByMidACid(mid, cid);
			Util.showArrayList(al2, "mid电影中cid影院的场次信息");
			System.out.println("请输入您想要看的场厅hid");
			int hid = Util.nextint();
			ArrayList<Session> al3 = sb.findSessionByMidACidASid(mid, cid, hid);
			Util.showArrayList(al3, "mid电影中cid影院的hid场次信息");
			System.out.println("请选择场次");
			int sid = Util.nextint();
			if (sb.CanBuyTicket(cid, mid, hid, sid)) {
				System.out.println("可选的座位号如下（0为可选，1为不可选）");
				sb.printSeat(mid, cid, hid, sid);
				System.out.println("请输入您想要座位的行数");
				int row = Util.nextint();
				System.out.println("请输入您想要座位的列数");
				int column = Util.nextint();
				if (sb.getRemain(sid, row, column) == 1) {
					System.out.println("您所选择的座位已经被选择了");
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
						System.out.println("购买成功！");
						if (Util.isGoOn()) {
							continue;
						} else {
							return;
						}
					} else {
						System.out.println("您的余额不足，请问是否充值");
						System.out.println("1. 是");
						System.out.println("2. 否");
						choose = in.next();
						switch (choose) {
						case "1":
							recharge();
							break;
						case "2":
							System.out.println("不充值无法购买，将回到上一级界面");
							return;
						default:
							System.out.println("输入错误，自动默认不充值");
							return;
						}
					}
				}

			} else {
				System.out.println("您所需要的场次已经没有票了");
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
			System.out.println("没有该用户的消费记录");
		} else {
			while (true) {
				Util.delimiter();
				System.out.println("请您选择所需要的操作");
				System.out.println("1. 查看未开始的订单");
				System.out.println("2. 查看未完成的订单");
				System.out.println("3. 查看已经完成的订单");
				System.out.println("4. 查看所有的订单");
				System.out.println("0. 退出");
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
					System.out.println("输入错误");
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
			Util.showArrayList(al, "还未开始的订单");
			System.out.println("请问需要取消订单吗？");
			System.out.println("1. 是");
			System.out.println("2. 否");
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
			System.out.println("请输入tid");
			int tid = Util.nextint();
			long currenttime = System.currentTimeMillis();
			String startTime = tb.returnStartTime(tid);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date start = sdf.parse(startTime);
				long starttime = start.getTime();
				if (starttime - currenttime < 30 * 60 * 1000) {
					System.out.println("不可退票");
				} else {
					double refundmoney = tb.returnmoney(tid);
					ub.refundMoney(tid, refundmoney);
					tb.refundTicket(tid);
					System.out.println("退票成功");
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
		Util.showArrayList(al, "已经开始但是还没有完成的订单");

	}

	public void finishedRecord() {
		Util.delimiter();
		String currentTime = Util.getCurrentTime();
		long currenttime = Util.getLongTime(currentTime);
		ArrayList<Ticket> al = tb.returnstarttime(userid, currenttime);
		Util.showArrayList(al, "已经完成的订单");
		ArrayList<Ticket> al2 = tb.unfinishComment(userid,al);
		if (al2.size() != 0) {
			Util.delimiter();
			System.out.println("在您已经完成的订单内有未评论的电影");
			System.out.println("请问是否评论？");
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
			System.out.println("没有未评论的电影");
		}

	}

	public void comment() {
		while (true) {
			Util.delimiter();
			String currentTime = Util.getCurrentTime();
			long currenttime = Util.getLongTime(currentTime);
			ArrayList<Ticket> al = tb.returnstarttime(userid, currenttime);
			ArrayList<Ticket> al2 = tb.unfinishComment(userid,al);
			Util.showArrayList(al2, "已经完成但是没有评论的订单");
			System.out.println("请输入您要完成的电影mid");
			int mid = Util.nextint();
			System.out.println("请输入您要完成的电影的评价");
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
		Util.showArrayList(al, userid + "的消费记录");
	}

}
