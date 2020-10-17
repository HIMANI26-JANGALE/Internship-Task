package com.model;

public class TransferAmount {
	String sender_account_no;
	String sender_name;
	String receiver_account_no;
	String receiver_name;
	double amount;
	public String getSender_account_no() {
		return sender_account_no;
	}
	public void setSender_account_no(String sender_account_no) {
		this.sender_account_no = sender_account_no;
	}
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public String getReceiver_account_no() {
		return receiver_account_no;
	}
	public void setReceiver_account_no(String receiver_account_no) {
		this.receiver_account_no = receiver_account_no;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
