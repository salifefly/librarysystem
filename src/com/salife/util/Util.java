package com.salife.util;

//import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Base64;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	public static Scanner in = new Scanner(System.in);

	public static <T> void showArrayList(ArrayList<T> al, String str) {
		System.out.println("=======================" + str + "=======================");
		if (al.size() == 0) {
			System.out.println("数据不存在");
		} else {
			for (T t : al) {
				System.out.println(t);
			}
		}
	}

	public static boolean isGoOn() {
		System.out.println("请问是否需要继续？(y/n)");
		String str = in.next();
		if (str.charAt(0) == 'y') {
			return true;
		}
		return false;

	}

	public static void delimiter() {
		System.out.println("========================================================");
	}

	public static String overTime(String startTime, String duration) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date start = sdf.parse(startTime);
			String[] durations = duration.split(":");
			long durationtime = (Integer.parseInt(durations[0]) * 3600 + Integer.parseInt(durations[1]) * 60
					+ Integer.parseInt(durations[2])) * 1000;
			Date over = new Date(start.getTime() + durationtime);
			String overTime = sdf.format(over);
			return overTime;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String currenttime = sdf.format(currentTime);
		return currenttime;
	}

	@SuppressWarnings("finally")
	public static long getLongTime(String time) {
		long longtime = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date longTime = sdf.parse(time);
			longtime = longTime.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return longtime;

		}

	}

	public static int nextint() {
		int input = 0;
		while (true) {
			try {
				input = in.nextInt();
				if (input > 0) {
					return input;
				}
			} catch (Exception e) {
				System.out.println("输入错误，请重新输入");
				in.next();
			}
		}
	}

	public static double nextdouble() {
		double input = 0;
		while (true) {
			try {
				input = in.nextDouble();
				return input;
			} catch (InputMismatchException e) {
				System.out.println("输入错误，请重新输入");
				in.next();
			}
		}
	}

	public static String md5(String str) {
		// 定义一个字节数组
		byte[] secretBytes = null;
		// 生成一个MD5加密计算摘要
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			// 对字符串进行加密
			md5.update(str.getBytes());
			// 获得加密后的数据
			secretBytes = md5.digest();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		// 将加密后的数据转换为16进制数字
		String md5code = new BigInteger(1, secretBytes).toString(16);
		// 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;

	}

	public static String nexT(String matchstr, String string) {
		String str = null;
		while (true) {
			str = in.next();
			if (str.matches(matchstr)) {
				return str;
			} else {
				System.out.println("您所输入的信息不匹配，请输入" + string);
				continue;
			}

		}

	}
}

//while(true) {
//	Util.delimiter();
//	if(Util.isGoOn()){
//		continue;
//	}else{
//		return;
//	}
//}
//Util.nextint();
//Util.nextdouble();
