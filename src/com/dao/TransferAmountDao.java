package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import com.model.TransferAmount;



public class TransferAmountDao {
	Connection con=null;
	PreparedStatement ps;
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","hrj13112001");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public int saveData(List<TransferAmount> lst){
		TransferAmount r=lst.get(0);
		con=getConnection();
		int i=0;
		
		try {
			ps=con.prepareStatement("insert into transfer values(?,?,?,?,?)");
			ps.setString(1,r.getSender_account_no());
			ps.setString(2,r.getSender_name());
			ps.setString(3,r.getReceiver_account_no());
			ps.setString(4,r.getReceiver_name());
			ps.setDouble(5,r.getAmount());
			i=ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int balEnq(String accNo,Double amount) {
		System.out.println("bal enquiry");
		con=getConnection();
		double bal=0.0;
		int i=0;
		try {
			ps=con.prepareStatement("Select current_balance From customer WHERE account_no=?");
			ps.setString(1, accNo);
						
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				 bal=rs.getDouble(4);
				
			}
			if(bal>amount){
				i=1;
			}
			else{
				i=0;
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int deposit(String accNo,double amount) {
		con=getConnection();
		float bal=0.0f;
		int i=0;
		try {
			
			ps=con.prepareStatement("Update customer set current_balance=current_balance+? WHERE account_no=?");
			ps.setDouble(1,amount);
			ps.setString(2, accNo);
			
			 i=ps.executeUpdate();
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int withdraw(String accNo,double amount) {
		con=getConnection();
		float bal=0.0f;
		int i=0;
		try {
			
			ps=con.prepareStatement("Update customer set current_balance=current_balance-? WHERE account_no=?");
			ps.setDouble(1,amount);
			ps.setString(2, accNo);
			
			 i=ps.executeUpdate();
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
