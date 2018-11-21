package com.salife.dao.impl;

import java.io.*;
import java.util.ArrayList;

public class BaseDao{
	protected File file;
	protected FileInputStream fis;
	protected FileOutputStream fos;
	protected ObjectInputStream ois;
	protected ObjectOutputStream oos;

	public <T> void write(ArrayList<T> al) {
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(al);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}

	}

	@SuppressWarnings("unchecked")
	public <T> ArrayList<T> read() {
		ArrayList<T> al = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			al = (ArrayList<T>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			al = new ArrayList<T>();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return al;

	}
	public void closeAll() {
		if(ois!=null) {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(oos!=null) {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
