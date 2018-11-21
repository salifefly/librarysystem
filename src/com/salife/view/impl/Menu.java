package com.salife.view.impl;

import java.util.Scanner;

import com.salife.util.Util;

public class Menu {
	private Scanner in = new Scanner(System.in);
	private String choose = null;

	public void mainMenu() {
		while (true) {
			Util.delimiter();
			System.out.println("欢迎来带电影院管理系统");
			System.out.println("1.Admin管理员登录");
			System.out.println("2.电影院管理员登录");
			System.out.println("3.user登录");
			System.out.println("4. 退出");
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
