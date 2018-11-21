package com.salife.biz;

import java.util.ArrayList;

import com.salife.entity.Ticket;

public interface TicketBiz {
	
	public String buyTicket(Ticket ticket);
	
	public void addTicket(Ticket ticket);
	
	public ArrayList<Ticket> returnStartTime(int userid,long currenttime);
	
	public ArrayList<Ticket> returnstartTime(int userid,long currenttime);
	
	public ArrayList<Ticket> returnstarttime(int userid,long currenttime);
	
	public ArrayList<Ticket> unfinishComment(int userid,ArrayList<Ticket> al);
	
	public void completeComment(int userid,int mid,String comment);
	
	public void deleteTicketByMid(int mid);
	
	public ArrayList<Integer> returnUidByMid(int mid);
	
	public String returnStartTime(int tid); 
	
	public void refundTicket(int tid);
	
	public double returnmoney(int tid);
	
}
