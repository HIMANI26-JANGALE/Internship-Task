package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Search;
import com.mysql.cj.xdevapi.Statement;
import com.sun.corba.se.pept.transport.Connection;
/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String acc_no=request.getParameter("sacc_no");
		java.sql.Connection con=null;
		pw.print("<body background='https://i.pinimg.com/originals/83/46/e3/8346e3dfd4f4c0cd0eca058c1c06758f.png' style='background-size: cover' style='background-position:center' style='background-repeat:no-repeat' style='background-attachment:fixed'>");
		pw.print("<table border='1 px ' style='background-color:lightcoral' style='font-size:24px' style='background-color:lightcoral' width=600px height=100px align='center' style='align-top:500px'><tr ><th style= 'font-size:24px'>Account No</th><th style= 'font-size:24px'>Name</th><th style= 'font-size:24px'>Email<th style= 'font-size:24px'>Current Balance</th></th></tr>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","hrj13112001");
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select *from customer where account_no="+acc_no+"");
			while(rs.next()){
				pw.print("<tr><td style= 'font-size:24px' >");
				pw.print(rs.getInt(1));
				pw.print("</td>");
				pw.print("<td style= 'font-size:24px'>");
				pw.print(rs.getString(2));
				pw.print("</td>");
				pw.print("<td style= 'font-size:24px'>");
				pw.print(rs.getString(3));
				pw.print("</td>");
				pw.print("<td style= 'font-size:24px'>");
				pw.print(rs.getDouble(4));
				pw.print("</td>");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
