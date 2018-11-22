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
			System.out.println("���������Ĺ���Ա�˺�");
			String account = in.next();
			Administrators administrator = new Administrators(account);
			if (!ab.findByAccount(administrator)) {
				System.out.println("����Ա�˺Ų����ڣ�");
			} else {
				admin = account;
				System.out.println("����Ա�˺�������ȷ");
				while (true) {
					System.out.println("���������Ա����");
					String password = in.next();
					Administrators administrator2 = new Administrators(account, password);
					if (!ab.correctPassword(administrator2)) {
						System.out.println("����Ա�������");
						if (Util.isGoOn()) {
							continue;
						} else {
							return;
						}
					} else {
						System.out.println("��¼�ɹ�");
						while (true) {
							Util.delimiter();
							if (ab.returncompInfo(admin) == 0) {
								System.out.println("����δ����������Ϣ���밴�����������������");
								while (true) {
									System.out.println("������cid");
									int cid = Util.nextint();
									// admincid = cid;(��������û�а�cid����admincid)
									if (!cb.findByCId(cid)) {
										System.out.println("�����cid������");
										if (Util.isGoOn()) {
											continue;
										} else {
											return;
										}
									} else {
										break;
									}
								}
								System.out.println("������name");
								String name = in.next();
								System.out.println("������sex");
								String sex = in.next();
								System.out.println("������email");
								String email = in.next();
								System.out.println("������phonenumber");
								String phonenumber = in.next();
								ab.finishInfo(admin, admincid, name, sex, email, phonenumber);
								System.out.println("���Ƴɹ�");
								continue;
							} else {
								System.out.println("1. ����Ա");
								System.out.println("2. ��Ӱ");
								System.out.println("3. �鿴�ּ�¼");
								System.out.println("4. ����");
								System.out.println("5. ����");
								System.out.println("0. ������һ��");
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
									System.out.println("��������ȷ��ѡ��");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. �޸Ĺ���Ա");
			System.out.println("0. ������һ��");
			choose = in.next();
			switch (choose) {
			case "1":
				updateAdmin();
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

	@Override
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

	@Override
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

	@Override
	public void optionByMovie() {
		while (true) {
			Util.delimiter();
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ��ӵ�Ӱ");
			System.out.println("2. ɾ����Ӱ");
			System.out.println("3. �޸ĵ�Ӱ");
			System.out.println("4. ���ҵ�Ӱ");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	@Override
	public void addMovie() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫ��ӵĵ�Ӱ����");
			String name = in.next();
			if (!mb.findByName(name)) {
				System.out.println("��������Ҫ��ӵĵ�Ӱ����");
				String detail = in.next();
				System.out.println("��������Ҫ��ӵĵ�Ӱʱ��(hh:mm:ss)");
				String matchstr = "([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
				String string = "HH:MM:SS";
				String duration = Util.nexT(matchstr, string);
				System.out.println("��������Ҫ��ӵĵ�Ӱ����");
				String type = in.next();
				System.out.println("��������Ҫ��ӵĵ�Ӱ�۸�");
				double price = Util.nextdouble();
				Movie movie = new Movie(name, detail, duration, type, price);
				mb.addByName(movie);
				System.out.println("��ӳɹ�");
			} else {
				System.out.println("�Ѿ��������������name�ĵ�Ӱ�����ʧ��");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ����nameɾ����Ӱ");
			System.out.println("2. ����midɾ����Ӱ");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	@Override
	public void deleteMovieByName() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫɾ���ĵ�Ӱ��name");
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
				System.out.println("ɾ���ɹ�");
				System.out.println("�����Ѿ�����ĵ�Ӱ�Ѿ�����");
			} else {
				System.out.println("������ĵ�Ӱname�����ڣ�ɾ��ʧ��");
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
			System.out.println("��������Ҫɾ���ĵ�Ӱ��mid");
			int mid = Util.nextint();
			if (mb.findByMId(mid)) {
				mb.deleteMovieByMId(mid);
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("������ĵ�Ӱmid�����ڣ�ɾ��ʧ��");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ����name�޸ĵ�Ӱ");
			System.out.println("2. ����mid�޸ĵ�Ӱ");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	@Override
	public void updateMovieByName() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫ�޸ĵĵ�Ӱ��name");
			String name = in.next();
			if (mb.findByName(name)) {
				System.out.println("��������Ҫ��ӵĵ�Ӱ����");
				String detail = in.next();
				System.out.println("��������Ҫ��ӵĵ�Ӱʱ��");
				String duration = in.next();
				System.out.println("��������Ҫ��ӵĵ�Ӱ����");
				String type = in.next();
				System.out.println("��������Ҫ��ӵĵ�Ӱ�۸�");
				double price = Util.nextdouble();
				Movie movie = new Movie(name, detail, duration, type, price);
				mb.updateMovieByName(movie);
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("û�в鵽����Ҫ�޸ĵĵ�Ӱ");
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
			System.out.println("��������Ҫ�޸ĵĵ�Ӱ��mid");
			int mid = Util.nextint();
			if (mb.findByMId(mid)) {
				System.out.println("��������Ҫ��ӵĵ�Ӱ����");
				String detail = in.next();
				System.out.println("��������Ҫ��ӵĵ�Ӱʱ��");
				String duration = in.next();
				System.out.println("��������Ҫ��ӵĵ�Ӱ����");
				String type = in.next();
				System.out.println("��������Ҫ��ӵĵ�Ӱ�۸�");
				double price = Util.nextdouble();
				String name = mb.returnNameByMId(mid);
				Movie movie = new Movie(name, detail, duration, type, price);
				mb.updateMovieByName(movie);
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("û�в鵽����Ҫ�޸ĵĵ�Ӱ");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ��ѯ����");
			System.out.println("2. ����mid��ѯ");
			System.out.println("3. ����name��ѯ");
			System.out.println("4. ����type��ѯ");
			System.out.println("5. ����price��ѯ");// ��Ϊ����
			System.out.println("6. ����duration��ѯ");// ��Ϊ����
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	@Override
	public void searchByAll() {
		while (true) {
			Util.delimiter();
			ArrayList<Movie> al = mb.findByAll();
			Util.showArrayList(al, "���еĵ�Ӱ��Ϣ");
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
			System.out.println("��������Ҫ�����ĵ�Ӱmid");
			int mid = Util.nextint();
			ArrayList<Movie> al = mb.searchByMId(mid);
			if (al.size() != 0) {
				Util.showArrayList(al, "��Ҫ�����ĵ�Ӱmid��Ϣ");
			} else {
				System.out.println("���������ĵ�Ӱmid������");
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
			System.out.println("��������Ҫ�����ĵ�Ӱname");
			String name = in.next();
			ArrayList<Movie> al = mb.searchByName(name);
			if (al.size() != 0) {
				Util.showArrayList(al, "��Ҫ�����ĵ�Ӱname��Ϣ");
			} else {
				System.out.println("���������ĵ�Ӱname������");
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
			System.out.println("��������Ҫ�����ĵ�Ӱtype");
			String type = in.next();
			ArrayList<Movie> al = mb.searchByType(type);
			if (al.size() != 0) {
				Util.showArrayList(al, "��Ҫ�����ĵ�Ӱtype��Ϣ");
			} else {
				System.out.println("���������ĵ�Ӱtype������");
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
			System.out.println("��������Ҫ�����ĵ�Ӱprice");
			double price = Util.nextdouble();
			ArrayList<Movie> al = mb.searchByPrice(price);
			if (al.size() != 0) {
				Util.showArrayList(al, "��Ҫ�����ĵ�Ӱ����price��Ϣ");
			} else {
				System.out.println("���������ĵ�Ӱ����price������");
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
			System.out.println("��������Ҫ�����ĵ�Ӱduration");
			String duration = in.next();
			ArrayList<Movie> al = mb.searchByDuration(duration);
			if (al.size() != 0) {
				Util.showArrayList(al, "��Ҫ�����ĵ�Ӱduration��Ϣ");
			} else {
				System.out.println("���������ĵ�Ӱduration������");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			Util.delimiter();
			System.out.println("1. ��ӳ���");
			System.out.println("2. ɾ������");
			System.out.println("3. �޸ĳ���");
			System.out.println("4. ���ҳ���");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	@Override
	public void addHall() {
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫ��ӵĳ������ڵ�ӰԺcid");
			int cid = Util.nextint();
			if (cb.findByCId(cid)) {
				System.out.println("����������Ҫ��ӳ�����name");
				String name = in.next();
				if (!hb.findByName(name)) {
					Hall hall = new Hall(name, cid);
					hb.addHall(hall);
					System.out.println("��ӳɹ�");
				} else {
					System.out.println("���������name�Ѿ�������");
				}
			} else {
				System.out.println("û�����������cid��ӰԺ");
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
			System.out.println("��������Ҫɾ��������hid");
			int hid = Util.nextint();
			if (hb.findByHId(hid)) {
				ArrayList<Hall> al = hb.searchByHId(hid);
				Util.showArrayList(al, "���ҵĳ���hid");
				System.out.println("��������Ҫɾ���������ڵ�ӰԺcid");
				int cid = Util.nextint();
				hb.deleteByHId(hid, cid);
			} else {
				System.out.println("���������hid������");
			}
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}
	}

	@Override
	public void updateHall() {// cidӦ�����ж�
		while (true) {
			Util.delimiter();
			System.out.println("��������Ҫ�޸ĵĳ�����hid");
			int hid = Util.nextint();
			if (hb.findByHId(hid)) {
				System.out.println("��������Ҫ�޸ĵĳ�����name");
				String name = in.next();
				System.out.println("��������Ҫ�޸ĵĳ�������");
				int capacity = Util.nextint();
				int cid = hb.returnCId(hid);
				Hall hall = new Hall(hid, name, cid, capacity);
				hb.updateByHId(hall);
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("���������hid������");
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
			System.out.println("��ѡ�����Ĳ���");
			System.out.println("1. ����hid����hall");
			System.out.println("2. �鿴����hall");
			System.out.println("0. ������һ��");
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
			System.out.println("��������Ҫ���ҵĳ���hid");
			int hid = Util.nextint();
			if (hb.findByHId(hid)) {
				ArrayList<Hall> al = hb.searchByHId(hid);
				Util.showArrayList(al, "���ҵĳ���hid");
			} else {
				System.out.println("���������hid������");
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
			Util.showArrayList(al, "����hall����Ϣ");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			Util.delimiter();
			System.out.println("1. ��ӳ���");
			System.out.println("2. ɾ������");
			System.out.println("3. �޸ĳ���");
			System.out.println("4. ���ҳ���");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	@Override
	public void addSession() {// ��Ҫ�Ͳ���ʱ��+��Ӱʱ��
		while (true) {
			Util.delimiter();
			a: while (true) {
				System.out.println("��������Ҫ��ӵĳ��εĵ�ӰԺcid");
				int cid = Util.nextint();
				if (!cb.findByCId(cid)) {
					System.out.println("û���ҵ����cid");
				} else {
					while (true) {
						System.out.println("��������Ҫ��ӵĳ��εĳ���hid");
						int hid = Util.nextint();
						if (!hb.findByHId(hid)) {
							System.out.println("û���ҵ����hid");

						} else {
							while (true) {
								System.out.println("��������Ҫ��ĳ��������ŵĵ�Ӱmid");
								int mid = Util.nextint();
								if (!mb.findByMId(mid)) {
									System.out.println("û���ҵ����mid");
								} else {
									String text = in.nextLine();
									System.out.println("��������Ҫ��ĳ��������ŵĵ�Ӱ��time");
//									String matchstr = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}";
//									String string = "YYYY-MM-DD HH:MM:SS";
//									String time = Util.nexT(matchstr, string);
									String time = in.nextLine();
									Session session = new Session(cid, hid, mid, time);
									if (!sb.confirmSession(session)) {
										sb.addSession(session);
										System.out.println("��ӳɹ�");
									} else {
										System.out.println("�������Ϣ�Ѿ����ڸó���");
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
			System.out.println("��������Ҫɾ���ĳ���sid");
			int sid = Util.nextint();
			if (sb.findBySid(sid)) {
				sb.deleteSessionBySid(sid);
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("û���ҵ��ó���sid");
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
			System.out.println("��������Ҫ�޸ĵĳ���sid");
			int sid = Util.nextint();
			if (sb.findBySid(sid)) {
				System.out.println("��������Ҫ�޸ĵĳ��εĲ���ʱ��");
				String time = in.next();
				sb.updateSessionBySid(sid, time);
			} else {
				System.out.println("û���ҵ��ó���sid");
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
			System.out.println("��ѡ��������Ҫ�Ĳ���");
			System.out.println("1. ��ѯ���г���");
			System.out.println("2. ����sid��ѯ����");
			System.out.println("3. ����hid��ѯ����");
			System.out.println("4. ����cid��ѯ����");
			System.out.println("5. ����time��ѯ����");
			System.out.println("0. ������һ��");
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
				System.out.println("��������ȷ��ѡ��");
				break;
			}
		}
	}

	@Override
	public void searchSessionByAll() {
		while (true) {
			Util.delimiter();
			ArrayList<Session> al = sb.findByAll();
			Util.showArrayList(al, "���г��ε���Ϣ");
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
			System.out.println("��������Ҫ��ѯ��sid");
			int sid = Util.nextint();
			ArrayList<Session> al = sb.findSessionBySid(sid);
			Util.showArrayList(al, "sid���ε���Ϣ");
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
			System.out.println("��������Ҫ��ѯ��hid");
			int hid = Util.nextint();
			ArrayList<Session> al = sb.findSessionByHid(hid);
			Util.showArrayList(al, "hid���ε���Ϣ");
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
			System.out.println("��������Ҫ��ѯ��cid");
			int cid = Util.nextint();
			ArrayList<Session> al = sb.findSessionByCid(cid);
			Util.showArrayList(al, "cid���ε���Ϣ");
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
			System.out.println("��������Ҫ��ѯ��time");
			String time = in.next();
			ArrayList<Session> al = sb.findSessionByTime(time);
			Util.showArrayList(al, "time���ε���Ϣ");
			if (Util.isGoOn()) {
				continue;
			} else {
				return;
			}
		}

	}
}
