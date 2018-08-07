package com.cg.pwa.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountBean {

	private String customerName;
	@Id
	private String mobileNum;
	private String emailId;
	private double balance;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountBean(String customerName, String mobileNum, String emailId,
			double balance) {
		super();
		this.customerName = customerName;
		this.mobileNum = mobileNum;
		this.emailId = emailId;
		this.balance = balance;
	}

	public AccountBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [customerName=" + customerName + ", mobileNum="
				+ mobileNum + ", emailId=" + emailId + ", balance=" + balance
				+ "]";
	}
}
