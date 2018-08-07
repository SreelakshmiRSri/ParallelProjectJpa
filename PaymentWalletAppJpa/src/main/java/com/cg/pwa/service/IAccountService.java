package com.cg.pwa.service;

import com.cg.pwa.bean.AccountBean;
import com.cg.pwa.exception.AccountException;

public interface IAccountService {
	AccountBean createAccount(AccountBean acc) throws AccountException;

	double showBalance(String mobNo) throws AccountException;

	double deposit(String mobNo, double amount) throws AccountException;

	double withdraw(String mobNo, double amount) throws AccountException;

	double fundTransfer(String srcMobNo, String destMobNo, double amount) throws AccountException;

	AccountBean printTransaction(String mobNo) throws AccountException;

	public boolean validateMobNo(String mobileNo) throws AccountException;

	public boolean validateName(String name) throws AccountException;

	public boolean validateEmail(String email) throws AccountException;

	public boolean validateBalance(double balance) throws AccountException;

	public boolean validateAmt(double amount) throws AccountException;

}
