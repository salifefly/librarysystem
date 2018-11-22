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
			System.out.println("====================��ӭʹ��ӰԺ��Ʊϵͳ====================");
			System.out.println("1. ��¼");
			System.out.println("0. �˳�");
			choose = in.next();
			switch (choose) {
			case "1":
				logOnMenu();
				break;
			case "0":
				return;
			default:
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	@Override
	public void logOnMenu() {
		while (true) {
			Util.delimiter();
			System.out.println("�����������ն˹���Ա�˺�");
			String account = in.next();
			if (!account.equals("admin")) {
				System.out.println("�ն˹���Ա�˺Ŵ���");
				continue;
			} else {
				System.out.println("�ն˹���Ա�˺�������ȷ");
				while (true) {
					System.out.println("�������ն˹���Ա����");
					String password = in.next();
					if (!password.equals("123")) {
						System.out.println("�ն˹���Ա�������");
						if (Util.isGoOn()) {
							continue;
						} else {
							return;
						}
					} else {
						System.out.println("��¼�ɹ�");
						while (true) {
							Util.delimiter();
							System.out.println("1. ����Ա");
							System.out.println("2. ӰԺ");
							System.out.println("3. �鿴�ܼ�¼");
							System.out.println("4. ��Ӱ");
							System.out.println("5. �鿴�ּ�¼");
							System.out.println("6. ����");
							System.out.println("7. ����");
							System.out.println("0. ������һ��");
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
								System.out.println("��������ȷ��ѡ��");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ע�����Ա");
			System.out.println("2. ɾ������Ա");
			System.out.println("3. �޸Ĺ���Ա");
			System.out.println("4. ���ҹ���Ա");
			System.out.println("5. �鿴���й���Ա");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	public void registAdmin() {
		while (true) {
			Util.delimiter();
			System.out.println("�����������˺�");
			String account = in.next();
			System.out.println("����");
			String matchstr = "^[a-zA-Z]\\w{5,17}$";
			String string = "����ĸ��ͷ��������6~18֮�䣬ֻ�ܰ����ַ������ֺ��»���";
			String password = Util.nexT(matchstr, string);
			Administrators administrator = new Administrators(account, password);
			if (ab.regist(administrator)) {
				System.out.println("ע��ɹ�");
				System.out.println("��ע�����ϢΪ");
				System.out.println(ab.registSuccess(administrator));
			} else {
				System.out.println("ע��ʧ��,account�Ѿ�����");
			}
//			ArrayList<Administrators> al = ab.findAll();
//			Util.showArrayList(al, "���й���Ա��Ϣ");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ����idɾ��");
			System.out.println("2. ����accountɾ��");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	public void deleteAdminById() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫɾ�����˺�id");
			int id = Util.nextint();
			if (ab.deleteById(id)) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("ɾ��ʧ�ܣ�û�����id");
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
			System.out.println("��������Ҫɾ�����˺�account");
			String account = in.next();
			Administrators administrator = new Administrators(account);
			if (ab.findByAccount(administrator)) {
				System.out.println("��������Ҫɾ���˺ŵ�����");
				String password = in.next();
				Administrators administrator2 = new Administrators(account, password);
				if (ab.deleteByAccount(administrator2)) {
					System.out.println("ɾ���ɹ�");
				} else {
					System.out.println("�����Ҫɾ�����˺ŵ����벻��ȷ");
				}
			} else {
				System.out.println("�˺��������ϵͳû���ҵ����˺�");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ����id�޸�");
			System.out.println("2. ����account�޸�");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	public void updateAdminById() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫ�޸ĵ��˺�id");
			int id = Util.nextint();
			if (ab.findById(id)) {
				System.out.println("��������Ҫ�޸ĵ��˺ŵ�����");
				String password = in.next();
				String account = ab.searchAdminById(id);
				Administrators administrator2 = new Administrators(account, password);
				if (ab.update(administrator2)) {
					System.out.println("�޸�����ɹ�");
				} else {
					System.out.println("�޸ĵ������ԭ������ͬ���޸�ʧ��");
				}
			} else {
				System.out.println("id�������ϵͳû���ҵ����˺�");
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
			System.out.println("��������Ҫ�޸ĵ��˺�account");
			String account = in.next();
			Administrators administrator = new Administrators(account);
			if (ab.findByAccount(administrator)) {
				System.out.println("��������Ҫ�޸ĵ��˺ŵ�����");
				String password = in.next();
				Administrators administrator2 = new Administrators(account, password);
				if (ab.update(administrator2)) {
					System.out.println("�޸�����ɹ�");
				} else {
					System.out.println("�޸ĵ������ԭ������ͬ���޸�ʧ��");
				}
			} else {
				System.out.println("account�������ϵͳû���ҵ����˺�");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ����id����");
			System.out.println("2. ����account����");
			System.out.println("3. ����name����");
			System.out.println("4. ����sex����");
			System.out.println("5. ����ӰԺid����");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	public void searchAdminByAId() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫ��ѯ���˺�id");
			int aid = Util.nextint();
			if (ab.findById(aid)) {
				System.out.println(ab.searchById(aid));
			} else {
				System.out.println("id�������ϵͳû���ҵ����˺�");
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
			System.out.println("��������Ҫ��ѯ���˺�account");
			String account = in.next();
			Administrators administrator = new Administrators(account);
			if (ab.findByAccount(administrator)) {
				Administrators administrator1 = ab.searchAdmin(administrator);
				System.out.println(administrator1);
			} else {
				System.out.println("�˺��������ϵͳû���ҵ����˺�");
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
			System.out.println("��������Ҫ��ѯ���˺�name");
			String name = in.next();
			if (ab.findByName(name)) {
				ArrayList<Administrators> al = ab.searchByName(name);
				Util.showArrayList(al, "������ѯ��name�������˺���Ϣ");
			} else {
				System.out.println("������ѯ��name������");
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
			System.out.println("��������Ҫ��ѯ���˺�sex");
			String sex = in.next();
			if (ab.findBySex(sex)) {
				ArrayList<Administrators> al = ab.searchBySex(sex);
				Util.showArrayList(al, "������ѯ��sex�������˺���Ϣ");
			} else {
				System.out.println("������ѯ��sex������");
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
			System.out.println("��������Ҫ��ѯ���˺�cid");
			int cid = Util.nextint();
			if (ab.findByCId(cid)) {
				ArrayList<Administrators> al = ab.searchByCId(cid);
				Util.showArrayList(al, "������ѯ��cid�������˺���Ϣ");
			} else {
				System.out.println("������ѯ��cid������");
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
		Util.showArrayList(al, "���й���Ա��Ϣ");
	}

	public void optionByCinema() {
		while (true) {
			Util.delimiter();
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ���ӰԺ");
			System.out.println("2. ɾ��ӰԺ");
			System.out.println("3. �޸�ӰԺ");
			System.out.println("4. ����ӰԺ");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	public void addCinema() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫ��ӵ�ӰԺ������");
			String name = in.next();
			System.out.println("��������Ҫ��ӵ�ӰԺ�ĵ�ַ");
			String address = in.next();
			Cinema cinema = new Cinema(name, address);
			if (cb.addCinmea(cinema)) {
				System.out.println("��ӳɹ�");
			} else {
				System.out.println("���ʧ�ܣ��õ�ַ���Ѿ��е�ӰԺ��");
			}
			ArrayList<Cinema> al = cb.findAll();
			Util.showArrayList(al, "���е�ӰԺ��Ϣ");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ����nameɾ��ӰԺ");
			System.out.println("2. ����addressɾ��ӰԺ");
			System.out.println("3. ����cidɾ��ӰԺ");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	public void deleteCinemaByName() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫɾ���ĵ�ӰԺname");
			String name = in.next();
			if (cb.findByName(name)) {
				ArrayList<Cinema> al = cb.searchByName(name);
				Util.showArrayList(al, "���е���ͬname��ӰԺ");
				System.out.println("��������Ҫɾ���ĵ�ӰԺcid");
				int cid = Util.nextint();
				if (cb.findByCId(cid)) {
					cb.deleteByCId(cid);
				} else {
					System.out.println("û��������Ҫɾ����cid��ɾ��ʧ��");
				}
			} else {
				System.out.println("���������name������");
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
			System.out.println("��������Ҫɾ���ĵ�ӰԺaddress");
			String address = in.next();
			Cinema cinema = new Cinema(address);
			if (cb.deleteCinema(cinema)) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("ɾ��ʧ�ܣ�û�������ַ��ӰԺ");
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
			System.out.println("��������Ҫɾ���ĵ�ӰԺcid");
			int cid = Util.nextint();
			if (cb.findByCId(cid)) {
				cb.deleteByCId(cid);
			} else {
				System.out.println("û��������Ҫɾ����cid��ɾ��ʧ��");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ����address�޸�ӰԺ");
			System.out.println("2. ����cid�޸�ӰԺ");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	public void updateCinemaByAddress() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫ�޸ĵ�ӰԺ��ַ");
			String address = in.next();
			System.out.println("��������Ҫ�޸ĵ�ӰԺ������");
			String name = in.next();
			Cinema cinema = new Cinema(name, address);
			if (cb.updateCinema(cinema)) {
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("û�������ַ��ӰԺ");
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
			System.out.println("��������Ҫ�޸ĵ�ӰԺcid");
			int cid = Util.nextint();
			if (cb.findByCId(cid)) {
				System.out.println("��������Ҫ�޸ĵ�ӰԺ����");
				String name = in.next();
				cb.updateByCid(cid, name);
			} else {
				System.out.println("û�����cid��ӰԺ");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ����address����ӰԺ");
			System.out.println("2. ����cid����ӰԺ");
			System.out.println("3. ����name����ӰԺ");
			System.out.println("4. �鿴����ӰԺ");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	public void searchCinemaByAddress() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫ���ҵ�ӰԺ��ַ");
			String address = in.next();
			if (cb.searchByAddress(address) != null) {
				System.out.println(cb.searchByAddress(address));
			} else {
				System.out.println("û�������ַ��ӰԺ");
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
			System.out.println("��������Ҫ���ҵ�ӰԺcid");
			int cid = Util.nextint();
			if (cb.findByCId(cid)) {
				System.out.println(cb.searchByCId(cid));
			} else {
				System.out.println("û�����cid��ӰԺ");
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
			System.out.println("��������Ҫ���ҵ�ӰԺname");
			String name = in.next();
			if (cb.findByName(name)) {
				ArrayList<Cinema> al = cb.searchByName(name);
				Util.showArrayList(al, "��Ҫ���ҵ�ӰԺname��Ϣ");
			} else {
				System.out.println("û���ҵ����name��ӰԺ");
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
			Util.showArrayList(al, "����ӰԺ��Ϣ");
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
			System.out.println("��ѡ��������Ĳ���");
			System.out.println("1. �鿴Ʊ��");
			System.out.println("2. �鿴ӰԺ��ӯ��");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	public void checkStatistics() {
		while (true) {
			Util.delimiter();
			System.out.println("����������Ҫ�鿴�ĵ�Ӱmid");
			int mid = Util.nextint();
			ArrayList<Statistics> al = stb.checkTurnOver(mid);
			Util.showArrayList(al, "��Ӱmid�ĵ�ӰƱ��");
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
			System.out.println("����������Ҫ�鿴��ӰԺcid");
			int cid = Util.nextint();
			ArrayList<Turnover> al = tub.checkTurnover(cid);
			Util.showArrayList(al, "ӰԺcid��ӯ��");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

}
