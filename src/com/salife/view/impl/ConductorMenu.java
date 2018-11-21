package com.salife.view.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.salife.biz.AdministratorsBiz;
import com.salife.biz.CinemaBiz;
import com.salife.biz.ConsumptionBiz;
import com.salife.biz.HallBiz;
import com.salife.biz.MovieBiz;
import com.salife.biz.SessionBiz;
import com.salife.biz.StatisticsBiz;
import com.salife.biz.TicketBiz;
import com.salife.biz.TurnoverBiz;
import com.salife.biz.UserBiz;
import com.salife.biz.impl.AdministratorsBizImpl;
import com.salife.biz.impl.CinemaBizImpl;
import com.salife.biz.impl.ConsumptionBizImpl;
import com.salife.biz.impl.HallBizImpl;
import com.salife.biz.impl.MovieBizImpl;
import com.salife.biz.impl.SessionBizImpl;
import com.salife.biz.impl.StatisticsBizImpl;
import com.salife.biz.impl.TicketBizImpl;
import com.salife.biz.impl.TurnoverBizImpl;
import com.salife.biz.impl.UserBizImpl;
import com.salife.entity.Administrators;
//import com.salife.entity.Cinema;
import com.salife.entity.Hall;
import com.salife.entity.Movie;
import com.salife.entity.Session;
import com.salife.util.Util;
import com.salife.view.Menu;

public class ConductorMenu implements Menu {
	private Scanner in = new Scanner(System.in);
	private String choose;
	private static String admin = null;
	private static int admincid = -1;
	private AdministratorsBiz ab = new AdministratorsBizImpl();
	private CinemaBiz cb = new CinemaBizImpl();
	private MovieBiz mb = new MovieBizImpl();
	private HallBiz hb = new HallBizImpl();
	private SessionBiz sb = new SessionBizImpl();
	private TicketBiz tb = new TicketBizImpl();
	private StatisticsBiz stb = new StatisticsBizImpl();
	private ConsumptionBiz cob = new ConsumptionBizImpl();
	private TurnoverBiz tub = new TurnoverBizImpl();
	private UserBiz ub = new UserBizImpl();

	@Override
	public void mainMenu() {
		while (true) {
			System.out.println("====================欢迎使用影院售票系统====================");
			System.out.println("1. 登录");
			System.out.println("0. 退出");
			choose = in.next();
			switch (choose) {
			case "1":
				logOnMenu();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void logOnMenu() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您的管理员账号");
			String account = in.next();
			Administrators administrator = new Administrators(account);
			if (!ab.findByAccount(administrator)) {
				System.out.println("管理员账号不存在！");
			} else {
				admin = account;
				System.out.println("管理员账号输入正确");
				while (true) {
					System.out.println("请输入管理员密码");
					String password = in.next();
					Administrators administrator2 = new Administrators(account, password);
					if (!ab.correctPassword(administrator2)) {
						System.out.println("管理员密码错误");
						if (Util.isGoOn()) {
							continue;
						} else {
							return;
						}
					} else {
						System.out.println("登录成功");
						while (true) {
							Util.delimiter();
							if (ab.returncompInfo(admin) == 0) {
								System.out.println("您还未完善您的信息，请按照下面操作进行完善");
								while (true) {
									System.out.println("请输入cid");
									int cid = Util.nextint();
									// admincid = cid;(这里最终没有把cid付给admincid)
									if (!cb.findByCId(cid)) {
										System.out.println("输入的cid不存在");
										if (Util.isGoOn()) {
											continue;
										} else {
											return;
										}
									} else {
										break;
									}
								}
								System.out.println("请输入name");
								String name = in.next();
								System.out.println("请输入sex");
								String sex = in.next();
								System.out.println("请输入email");
								String email = in.next();
								System.out.println("请输入phonenumber");
								String phonenumber = in.next();
								ab.finishInfo(admin, admincid, name, sex, email, phonenumber);
								System.out.println("完善成功");
								continue;
							} else {
								System.out.println("1. 管理员");
								System.out.println("2. 电影");
								System.out.println("3. 查看分记录");
								System.out.println("4. 场厅");
								System.out.println("5. 场次");
								System.out.println("0. 返回上一级");
								choose = in.next();
								switch (choose) {
								case "1":
									optionByAdministrator();
									break;
								case "2":
									optionByMovie();
									break;
								case "3":
									searchPartRecord();
									break;
								case "4":
									optionByHall();
									break;
								case "5":
									optionBySession();
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
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void optionByAdministrator() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 修改管理员");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				updateAdmin();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void updateAdmin() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 根据id修改");
			System.out.println("2. 根据account修改");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				updateAdminById();
				break;
			case "2":
				updateAdminByAccount();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void updateAdminById() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要修改的账号id");
			int id = Util.nextint();
			if (ab.findById(id)) {
				System.out.println("请输入您要修改的账号的密码");
				String password = in.next();
				String account = ab.searchAdminById(id);
				Administrators administrator2 = new Administrators(account, password);
				if (ab.update(administrator2)) {
					System.out.println("修改密码成功");
				} else {
					System.out.println("修改的密码和原密码相同，修改失败");
				}
			} else {
				System.out.println("id输入错误，系统没有找到该账号");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void updateAdminByAccount() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要修改的账号account");
			String account = in.next();
			Administrators administrator = new Administrators(account);
			if (ab.findByAccount(administrator)) {
				System.out.println("请输入您要修改的账号的密码");
				String password = in.next();
				Administrators administrator2 = new Administrators(account, password);
				if (ab.update(administrator2)) {
					System.out.println("修改密码成功");
				} else {
					System.out.println("修改的密码和原密码相同，修改失败");
				}
			} else {
				System.out.println("account输入错误，系统没有找到该账号");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void optionByMovie() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 添加电影");
			System.out.println("2. 删除电影");
			System.out.println("3. 修改电影");
			System.out.println("4. 查找电影");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				addMovie();
				break;
			case "2":
				deleteMovie();
				break;
			case "3":
				updateMovie();
				break;
			case "4":
				searchMovie();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void addMovie() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要添加的电影名字");
			String name = in.next();
			if (!mb.findByName(name)) {
				System.out.println("请输入您要添加的电影详情");
				String detail = in.next();
				System.out.println("请输入您要添加的电影时长(hh:mm:ss)");
				String matchstr = "([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
				String string = "HH:MM:SS";
				String duration = Util.nexT(matchstr, string);
				System.out.println("请输入您要添加的电影类型");
				String type = in.next();
				System.out.println("请输入您要添加的电影价格");
				double price = Util.nextdouble();
				Movie movie = new Movie(name, detail, duration, type, price);
				mb.addByName(movie);
				System.out.println("添加成功");
			} else {
				System.out.println("已经存在您所输入的name的电影，添加失败");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void deleteMovie() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 根据name删除电影");
			System.out.println("2. 根据mid删除电影");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				deleteMovieByName();
				break;
			case "2":
				deleteMovieByMId();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void deleteMovieByName() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要删除的电影的name");
			String name = in.next();
			if (mb.findByName(name)) {
				int mid = mb.returnMidByName(name);
				int leftseat = sb.returnTotalLeftSeat(mid);
				// ArrayList<Integer> al = sb.returnSidByMid(mid);
				stb.restitution(mid, leftseat);
				ArrayList<Integer> al2 = tb.returnUidByMid(mid);
				tb.deleteTicketByMid(mid);
				double backmoney = cob.returnBackMoney(al2);
				ArrayList<Double> al3 = cob.returnUidMoney(al2);
				ub.getBackMoney(al2, al3);
				admincid = ab.returnCid(admin);
				tub.setTurnover(admincid, backmoney);
				cob.deleteCon(al2);
				sb.deleteSessionByMid(mid);
				mb.deleteMovieByName(name);
				System.out.println("删除成功");
				System.out.println("所有已经购买的电影已经返还");
			} else {
				System.out.println("您输入的电影name不存在，删除失败");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void deleteMovieByMId() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要删除的电影的mid");
			int mid = Util.nextint();
			if (mb.findByMId(mid)) {
				mb.deleteMovieByMId(mid);
				System.out.println("删除成功");
			} else {
				System.out.println("您输入的电影mid不存在，删除失败");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void updateMovie() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 根据name修改电影");
			System.out.println("2. 根据mid修改电影");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				updateMovieByName();
				break;
			case "2":
				updateMovieByMId();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void updateMovieByName() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要修改的电影的name");
			String name = in.next();
			if (mb.findByName(name)) {
				System.out.println("请输入您要添加的电影详情");
				String detail = in.next();
				System.out.println("请输入您要添加的电影时长");
				String duration = in.next();
				System.out.println("请输入您要添加的电影类型");
				String type = in.next();
				System.out.println("请输入您要添加的电影价格");
				double price = Util.nextdouble();
				Movie movie = new Movie(name, detail, duration, type, price);
				mb.updateMovieByName(movie);
				System.out.println("修改成功");
			} else {
				System.out.println("没有查到您所要修改的电影");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void updateMovieByMId() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要修改的电影的mid");
			int mid = Util.nextint();
			if (mb.findByMId(mid)) {
				System.out.println("请输入您要添加的电影详情");
				String detail = in.next();
				System.out.println("请输入您要添加的电影时长");
				String duration = in.next();
				System.out.println("请输入您要添加的电影类型");
				String type = in.next();
				System.out.println("请输入您要添加的电影价格");
				double price = Util.nextdouble();
				String name = mb.returnNameByMId(mid);
				Movie movie = new Movie(name, detail, duration, type, price);
				mb.updateMovieByName(movie);
				System.out.println("修改成功");
			} else {
				System.out.println("没有查到您所要修改的电影");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void searchMovie() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 查询所有");
			System.out.println("2. 根据mid查询");
			System.out.println("3. 根据name查询");
			System.out.println("4. 根据type查询");
			System.out.println("5. 根据price查询");// 且为升序
			System.out.println("6. 根据duration查询");// 且为升序
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				searchByAll();
				break;
			case "2":
				searchByMId();
				break;
			case "3":
				searchByName();
				break;
			case "4":
				searchByType();
				break;
			case "5":
				searchByPrice();
				break;
			case "6":
				searchByDuration();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void searchByAll() {
		while (true) {
			Util.delimiter();
			ArrayList<Movie> al = mb.findByAll();
			Util.showArrayList(al, "所有的电影信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void searchByMId() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要搜索的电影mid");
			int mid = Util.nextint();
			ArrayList<Movie> al = mb.searchByMId(mid);
			if (al.size() != 0) {
				Util.showArrayList(al, "您要搜索的电影mid信息");
			} else {
				System.out.println("您所搜索的电影mid不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchByName() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要搜索的电影name");
			String name = in.next();
			ArrayList<Movie> al = mb.searchByName(name);
			if (al.size() != 0) {
				Util.showArrayList(al, "您要搜索的电影name信息");
			} else {
				System.out.println("您所搜索的电影name不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchByType() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要搜索的电影type");
			String type = in.next();
			ArrayList<Movie> al = mb.searchByType(type);
			if (al.size() != 0) {
				Util.showArrayList(al, "您要搜索的电影type信息");
			} else {
				System.out.println("您所搜索的电影type不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchByPrice() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要搜索的电影price");
			double price = Util.nextdouble();
			ArrayList<Movie> al = mb.searchByPrice(price);
			if (al.size() != 0) {
				Util.showArrayList(al, "您要搜索的电影高于price信息");
			} else {
				System.out.println("您所搜索的电影高于price不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchByDuration() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要搜索的电影duration");
			String duration = in.next();
			ArrayList<Movie> al = mb.searchByDuration(duration);
			if (al.size() != 0) {
				Util.showArrayList(al, "您要搜索的电影duration信息");
			} else {
				System.out.println("您所搜索的电影duration不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchPartRecord() {
		while (true) {
			Util.delimiter();
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void optionByHall() {
		while (true) {
			System.out.println("请选择您所需要的操作");
			Util.delimiter();
			System.out.println("1. 添加场厅");
			System.out.println("2. 删除场厅");
			System.out.println("3. 修改场厅");
			System.out.println("4. 查找场厅");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				addHall();
				break;
			case "2":
				deleteHall();
				break;
			case "3":
				updateHall();
				break;
			case "4":
				searchHall();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void addHall() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要添加的场厅所在的影院cid");
			int cid = Util.nextint();
			if (cb.findByCId(cid)) {
				System.out.println("请输入您所要添加场厅的name");
				String name = in.next();
				if (!hb.findByName(name)) {
					Hall hall = new Hall(name, cid);
					hb.addHall(hall);
					System.out.println("添加成功");
				} else {
					System.out.println("您所输入的name已经存在了");
				}
			} else {
				System.out.println("没有您所输入的cid的影院");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void deleteHall() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要删除场厅的hid");
			int hid = Util.nextint();
			if (hb.findByHId(hid)) {
				ArrayList<Hall> al = hb.searchByHId(hid);
				Util.showArrayList(al, "查找的场厅hid");
				System.out.println("请输入您要删除场厅所在的影院cid");
				int cid = Util.nextint();
				hb.deleteByHId(hid, cid);
			} else {
				System.out.println("您所输入的hid不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void updateHall() {// cid应该先判断
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要修改的场厅的hid");
			int hid = Util.nextint();
			if (hb.findByHId(hid)) {
				System.out.println("请输入您要修改的场厅的name");
				String name = in.next();
				System.out.println("请输入您要修改的场厅容量");
				int capacity = Util.nextint();
				int cid = hb.returnCId(hid);
				Hall hall = new Hall(hid, name, cid, capacity);
				hb.updateByHId(hall);
				System.out.println("修改成功");
			} else {
				System.out.println("您所输入的hid不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchHall() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您的操作");
			System.out.println("1. 根据hid查找hall");
			System.out.println("2. 查看所有hall");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				searchHallByHid();
				break;
			case "2":
				searchHallByAll();
				break;
			case "0":
				return;
			default:
				break;
			}
		}
	}

	@Override
	public void searchHallByHid() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查找的场厅hid");
			int hid = Util.nextint();
			if (hb.findByHId(hid)) {
				ArrayList<Hall> al = hb.searchByHId(hid);
				Util.showArrayList(al, "查找的场厅hid");
			} else {
				System.out.println("您所输入的hid不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void searchHallByAll() {
		while (true) {
			Util.delimiter();
			ArrayList<Hall> al = hb.findByAll();
			Util.showArrayList(al, "所有hall的信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void optionBySession() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			Util.delimiter();
			System.out.println("1. 添加场次");
			System.out.println("2. 删除场次");
			System.out.println("3. 修改场次");
			System.out.println("4. 查找场次");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				addSession();
				break;
			case "2":
				deleteSession();
				break;
			case "3":
				updateSession();
				break;
			case "4":
				searchSession();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void addSession() {// 需要和播放时间+电影时长
		while (true) {
			Util.delimiter();
			a: while (true) {
				System.out.println("请输入您要添加的场次的电影院cid");
				int cid = Util.nextint();
				if (!cb.findByCId(cid)) {
					System.out.println("没有找到这个cid");
				} else {
					while (true) {
						System.out.println("请输入您要添加的场次的场厅hid");
						int hid = Util.nextint();
						if (!hb.findByHId(hid)) {
							System.out.println("没有找到这个hid");

						} else {
							while (true) {
								System.out.println("请输入您要填的场次所播放的电影mid");
								int mid = Util.nextint();
								if (!mb.findByMId(mid)) {
									System.out.println("没有找到这个mid");
								} else {
									String text = in.nextLine();
									System.out.println("请输入您要填的场次所播放的电影的time");
//									String matchstr = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}";
//									String string = "YYYY-MM-DD HH:MM:SS";
//									String time = Util.nexT(matchstr, string);
									String time = in.nextLine();
									Session session = new Session(cid, hid, mid, time);
									if (!sb.confirmSession(session)) {
										sb.addSession(session);
										System.out.println("添加成功");
									} else {
										System.out.println("输入的信息已经存在该场次");
									}
									if (Util.isGoOn()) {
										break a;
									} else {
										return;
									}
								}
								if (Util.isGoOn()) {
									break a;
								} else {
									return;
								}
							}
						}
						if (Util.isGoOn()) {
							break a;
						} else {
							return;
						}
					}
				}
				if (Util.isGoOn()) {
					break a;
				} else {
					return;
				}
			}
		}
	}

	@Override
	public void deleteSession() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要删除的场次sid");
			int sid = Util.nextint();
			if (sb.findBySid(sid)) {
				sb.deleteSessionBySid(sid);
				System.out.println("删除成功");
			} else {
				System.out.println("没有找到该场次sid");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void updateSession() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要修改的场次sid");
			int sid = Util.nextint();
			if (sb.findBySid(sid)) {
				System.out.println("请输入您要修改的场次的播放时间");
				String time = in.next();
				sb.updateSessionBySid(sid, time);
			} else {
				System.out.println("没有找到该场次sid");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void searchSession() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 查询所有场次");
			System.out.println("2. 根据sid查询场次");
			System.out.println("3. 根据hid查询场次");
			System.out.println("4. 根据cid查询场次");
			System.out.println("5. 根据time查询场次");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				searchSessionByAll();
				break;
			case "2":
				searchSessionBySid();
				break;
			case "3":
				searchSessionByHid();
				break;
			case "4":
				searchSessionByCid();
				break;
			case "5":
				searchSessionByTime();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	@Override
	public void searchSessionByAll() {
		while (true) {
			Util.delimiter();
			ArrayList<Session> al = sb.findByAll();
			Util.showArrayList(al, "所有场次的信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchSessionBySid() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查询的sid");
			int sid = Util.nextint();
			ArrayList<Session> al = sb.findSessionBySid(sid);
			Util.showArrayList(al, "sid场次的信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchSessionByHid() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查询的hid");
			int hid = Util.nextint();
			ArrayList<Session> al = sb.findSessionByHid(hid);
			Util.showArrayList(al, "hid场次的信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchSessionByCid() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查询的cid");
			int cid = Util.nextint();
			ArrayList<Session> al = sb.findSessionByCid(cid);
			Util.showArrayList(al, "cid场次的信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	@Override
	public void searchSessionByTime() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查询的time");
			String time = in.next();
			ArrayList<Session> al = sb.findSessionByTime(time);
			Util.showArrayList(al, "time场次的信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}
}
