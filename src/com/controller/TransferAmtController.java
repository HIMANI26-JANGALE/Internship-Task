package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TransferAmountDao;
import com.model.TransferAmount;



/**
 * Servlet implementation class TransferAmtController
 */
@WebServlet("/TransferAmtController")
public class TransferAmtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferAmtController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sender_acc_no=request.getParameter("sacc_no");
		String sender_name=request.getParameter("sender_name");
		String receiver_acc_no=request.getParameter("racc_no");
		String receiver_name=request.getParameter("receiver_name");
		double amount=Double.parseDouble(request.getParameter("amount"));
		TransferAmount amt=new TransferAmount();
		amt.setSender_account_no(sender_acc_no);
		amt.setSender_name(sender_name);
		amt.setReceiver_account_no(receiver_acc_no);
		amt.setReceiver_name(receiver_name);
		amt.setAmount(amount);
		List<TransferAmount> lst=new ArrayList<TransferAmount>();
		lst.add(amt);
		TransferAmountDao rd=new TransferAmountDao();
		int i1=rd.balEnq(sender_acc_no,amount);
		int i=rd.saveData(lst);
		int deposit1=rd.deposit(receiver_acc_no, amount);
		if(deposit1>0){
			System.out.println("Amount deposited successfully");
		}
		int withdraw1=rd.withdraw(sender_acc_no,amount);
		if(withdraw1>0){
			System.out.println("Amount Withdraw successfully");
		}
		HttpSession session=request.getSession();
		
		if(i>0){
			session.setAttribute("display",lst);
			response.sendRedirect("Page.jsp");
		
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
