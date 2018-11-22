package com.salife.view.impl;

import java.util.Scanner;

import com.salife.util.Util;

public class Menu {
	private Scanner in = new Scanner(System.in);
	private String choose = null;

	public void mainMenu() {
		while (true) {
			Util.delimiter();
			System.out.println("��ӭ������ӰԺ����ϵͳ");
			System.out.println("1.Admin����Ա��¼");
			System.out.println("2.��ӰԺ����Ա��¼");
			System.out.println("3.user��¼");
			System.out.println("4. �˳�");
			choose = in.next();
			switch (choose) {
			case "1":
				new AdministratorMenu().mainMenu();
				break;
			case "2":
				new ConductorMenu().mainMenu();
				break;
			case "3":
				new UserMenu().mainMenu();
				break;
			case "4":
				return;
			default:
				break;
			}
		}
	}
}
