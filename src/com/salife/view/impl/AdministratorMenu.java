package com.salife.view.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.salife.biz.AdministratorsBiz;
import com.salife.biz.CinemaBiz;
import com.salife.biz.StatisticsBiz;
import com.salife.biz.TurnoverBiz;
//import com.salife.biz.HallBiz;
//import com.salife.biz.MovieBiz;
//import com.salife.biz.SessionBiz;
import com.salife.biz.impl.AdministratorsBizImpl;
import com.salife.biz.impl.CinemaBizImpl;
import com.salife.biz.impl.StatisticsBizImpl;
import com.salife.biz.impl.TurnoverBizImpl;
//import com.salife.biz.impl.HallBizImpl;
//import com.salife.biz.impl.MovieBizImpl;
//import com.salife.biz.impl.SessionBizImpl;
import com.salife.entity.Administrators;
import com.salife.entity.Cinema;
import com.salife.entity.Statistics;
import com.salife.entity.Turnover;
//import com.salife.entity.Hall;
//import com.salife.entity.Movie;
//import com.salife.entity.Session;
import com.salife.util.Util;
//import com.salife.view.AdminMenu;

public class AdministratorMenu extends ConductorMenu {
	private Scanner in = new Scanner(System.in);
	private String choose;
	private AdministratorsBiz ab = new AdministratorsBizImpl();
	private CinemaBiz cb = new CinemaBizImpl();
//	private MovieBiz mb = new MovieBizImpl();
//	private HallBiz hb = new HallBizImpl();
//	private SessionBiz sb = new SessionBizImpl();
	private StatisticsBiz stb = new StatisticsBizImpl();
	private TurnoverBiz tub = new TurnoverBizImpl();

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
			System.out.println("请输入您的终端管理员账号");
			String account = in.next();
			if (!account.equals("admin")) {
				System.out.println("终端管理员账号错误！");
				continue;
			} else {
				System.out.println("终端管理员账号输入正确");
				while (true) {
					System.out.println("请输入终端管理员密码");
					String password = in.next();
					if (!password.equals("123")) {
						System.out.println("终端管理员密码错误");
						if (Util.isGoOn()) {
							continue;
						} else {
							return;
						}
					} else {
						System.out.println("登录成功");
						while (true) {
							Util.delimiter();
							System.out.println("1. 管理员");
							System.out.println("2. 影院");
							System.out.println("3. 查看总记录");
							System.out.println("4. 电影");
							System.out.println("5. 查看分记录");
							System.out.println("6. 场厅");
							System.out.println("7. 场次");
							System.out.println("0. 返回上一级");
							choose = in.next();
							switch (choose) {
							case "1":
								optionByAdministrator();
								break;
							case "2":
								optionByCinema();
								break;
							case "3":
								searchAllRecord();
								break;
							case "4":
								optionByMovie();
								break;
							case "5":
								searchPartRecord();
								break;
							case "6":
								optionByHall();
								break;
							case "7":
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

	}

	@Override
	public void optionByAdministrator() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 注册管理员");
			System.out.println("2. 删除管理员");
			System.out.println("3. 修改管理员");
			System.out.println("4. 查找管理员");
			System.out.println("5. 查看所有管理员");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				registAdmin();
				break;
			case "2":
				deleteAdmin();
				break;
			case "3":
				updateAdmin();
				break;
			case "4":
				searchAdmin();
				break;
			case "5":
				searchAllAdmin();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	public void registAdmin() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您的账号");
			String account = in.next();
			System.out.println("密码");
			String matchstr = "^[a-zA-Z]\\w{5,17}$";
			String string = "以字母开头，长度在6~18之间，只能包含字符、数字和下划线";
			String password = Util.nexT(matchstr, string);
			Administrators administrator = new Administrators(account, password);
			if (ab.regist(administrator)) {
				System.out.println("注册成功");
				System.out.println("您注册的信息为");
				System.out.println(ab.registSuccess(administrator));
			} else {
				System.out.println("注册失败,account已经存在");
			}
//			ArrayList<Administrators> al = ab.findAll();
//			Util.showArrayList(al, "所有管理员信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void deleteAdmin() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 根据id删除");
			System.out.println("2. 根据account删除");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				deleteAdminById();
				break;
			case "2":
				deleteAdminByAccount();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	public void deleteAdminById() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要删除的账号id");
			int id = Util.nextint();
			if (ab.deleteById(id)) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败，没有这个id");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void deleteAdminByAccount() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要删除的账号account");
			String account = in.next();
			Administrators administrator = new Administrators(account);
			if (ab.findByAccount(administrator)) {
				System.out.println("请输入您要删除账号的密码");
				String password = in.next();
				Administrators administrator2 = new Administrators(account, password);
				if (ab.deleteByAccount(administrator2)) {
					System.out.println("删除成功");
				} else {
					System.out.println("输入的要删除的账号的密码不正确");
				}
			} else {
				System.out.println("账号输入错误，系统没有找到该账号");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

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

	public void searchAdmin() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 根据id查找");
			System.out.println("2. 根据account查找");
			System.out.println("3. 根据name查找");
			System.out.println("4. 根据sex查找");
			System.out.println("5. 根据影院id查找");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				searchAdminByAId();
				break;
			case "2":
				searchAdminByAccount();
				break;
			case "3":
				searchAdminByName();
				break;
			case "4":
				searchAdminBySex();
				break;
			case "5":
				searchAdminByCId();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	public void searchAdminByAId() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查询的账号id");
			int aid = Util.nextint();
			if (ab.findById(aid)) {
				System.out.println(ab.searchById(aid));
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

	public void searchAdminByAccount() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查询的账号account");
			String account = in.next();
			Administrators administrator = new Administrators(account);
			if (ab.findByAccount(administrator)) {
				Administrators administrator1 = ab.searchAdmin(administrator);
				System.out.println(administrator1);
			} else {
				System.out.println("账号输入错误，系统没有找到该账号");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void searchAdminByName() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查询的账号name");
			String name = in.next();
			if (ab.findByName(name)) {
				ArrayList<Administrators> al = ab.searchByName(name);
				Util.showArrayList(al, "您所查询的name的所有账号信息");
			} else {
				System.out.println("您所查询的name不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void searchAdminBySex() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查询的账号sex");
			String sex = in.next();
			if (ab.findBySex(sex)) {
				ArrayList<Administrators> al = ab.searchBySex(sex);
				Util.showArrayList(al, "您所查询的sex的所有账号信息");
			} else {
				System.out.println("您所查询的sex不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void searchAdminByCId() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查询的账号cid");
			int cid = Util.nextint();
			if (ab.findByCId(cid)) {
				ArrayList<Administrators> al = ab.searchByCId(cid);
				Util.showArrayList(al, "您所查询的cid的所有账号信息");
			} else {
				System.out.println("您所查询的cid不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void searchAllAdmin() {
		Util.delimiter();
		ArrayList<Administrators> al = ab.searchAllAdmin();
		Util.showArrayList(al, "所有管理员信息");
	}

	public void optionByCinema() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 添加影院");
			System.out.println("2. 删除影院");
			System.out.println("3. 修改影院");
			System.out.println("4. 查找影院");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				addCinema();
				break;
			case "2":
				deleteCinema();
				break;
			case "3":
				updateCinema();
				break;
			case "4":
				searchCinema();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	public void addCinema() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要添加的影院的名称");
			String name = in.next();
			System.out.println("请输入您要添加的影院的地址");
			String address = in.next();
			Cinema cinema = new Cinema(name, address);
			if (cb.addCinmea(cinema)) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败，该地址上已经有电影院了");
			}
			ArrayList<Cinema> al = cb.findAll();
			Util.showArrayList(al, "所有电影院信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void deleteCinema() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 根据name删除影院");
			System.out.println("2. 根据address删除影院");
			System.out.println("3. 根据cid删除影院");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				deleteCinemaByName();
				break;
			case "2":
				deleteCinemaByAddress();
				break;
			case "3":
				deleteCinemaByCid();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	public void deleteCinemaByName() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要删除的电影院name");
			String name = in.next();
			if (cb.findByName(name)) {
				ArrayList<Cinema> al = cb.searchByName(name);
				Util.showArrayList(al, "所有的相同name的影院");
				System.out.println("请输入您要删除的电影院cid");
				int cid = Util.nextint();
				if (cb.findByCId(cid)) {
					cb.deleteByCId(cid);
				} else {
					System.out.println("没有您所需要删除的cid，删除失败");
				}
			} else {
				System.out.println("您所输入的name不存在");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void deleteCinemaByAddress() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要删除的电影院address");
			String address = in.next();
			Cinema cinema = new Cinema(address);
			if (cb.deleteCinema(cinema)) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败，没有这个地址的影院");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void deleteCinemaByCid() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要删除的电影院cid");
			int cid = Util.nextint();
			if (cb.findByCId(cid)) {
				cb.deleteByCId(cid);
			} else {
				System.out.println("没有您所需要删除的cid，删除失败");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void updateCinema() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 根据address修改影院");
			System.out.println("2. 根据cid修改影院");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				updateCinemaByAddress();
				break;
			case "2":
				updateCinemaByCid();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	public void updateCinemaByAddress() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要修改的影院地址");
			String address = in.next();
			System.out.println("请输入您要修改的影院的名字");
			String name = in.next();
			Cinema cinema = new Cinema(name, address);
			if (cb.updateCinema(cinema)) {
				System.out.println("修改成功");
			} else {
				System.out.println("没有这个地址的影院");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void updateCinemaByCid() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要修改的影院cid");
			int cid = Util.nextint();
			if (cb.findByCId(cid)) {
				System.out.println("请输入您要修改的影院名字");
				String name = in.next();
				cb.updateByCid(cid, name);
			} else {
				System.out.println("没有这个cid的影院");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void searchCinema() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需要的操作");
			System.out.println("1. 根据address查找影院");
			System.out.println("2. 根据cid查找影院");
			System.out.println("3. 根据name查找影院");
			System.out.println("4. 查看所有影院");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				searchCinemaByAddress();
				break;
			case "2":
				searchCinemaByCid();
				break;
			case "3":
				searchCinemaByName();
				break;
			case "4":
				searchCinemaByAll();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	public void searchCinemaByAddress() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查找的影院地址");
			String address = in.next();
			if (cb.searchByAddress(address) != null) {
				System.out.println(cb.searchByAddress(address));
			} else {
				System.out.println("没有这个地址的影院");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void searchCinemaByCid() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查找的影院cid");
			int cid = Util.nextint();
			if (cb.findByCId(cid)) {
				System.out.println(cb.searchByCId(cid));
			} else {
				System.out.println("没有这个cid的影院");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void searchCinemaByName() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您要查找的影院name");
			String name = in.next();
			if (cb.findByName(name)) {
				ArrayList<Cinema> al = cb.searchByName(name);
				Util.showArrayList(al, "您要查找的影院name信息");
			} else {
				System.out.println("没有找到这个name的影院");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void searchCinemaByAll() {
		while (true) {
			Util.delimiter();
			ArrayList<Cinema> al = cb.findAll();
			Util.showArrayList(al, "所有影院信息");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	public void searchAllRecord() {
		while (true) {
			Util.delimiter();
			System.out.println("请选择您所需的操作");
			System.out.println("1. 查看票房");
			System.out.println("2. 查看影院的盈利");
			System.out.println("0. 返回上一级");
			choose = in.next();
			switch (choose) {
			case "1":
				checkStatistics();
				break;
			case "2":
				checkTurnover();
				break;
			case "0":
				return;
			default:
				System.out.println("请输入正确的选择");
				break;
			}
		}
	}

	public void checkStatistics() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您需要查看的电影mid");
			int mid = Util.nextint();
			ArrayList<Statistics> al = stb.checkTurnOver(mid);
			Util.showArrayList(al, "电影mid的电影票房");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}

	public void checkTurnover() {
		while (true) {
			Util.delimiter();
			System.out.println("请输入您需要查看的影院cid");
			int cid = Util.nextint();
			ArrayList<Turnover> al = tub.checkTurnover(cid);
			Util.showArrayList(al, "影院cid的盈利");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

}
