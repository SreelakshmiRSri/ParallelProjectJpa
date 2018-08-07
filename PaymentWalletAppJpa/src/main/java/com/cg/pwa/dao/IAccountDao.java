package com.cg.pwa.dao;

import com.cg.pwa.bean.AccountBean;
import com.cg.pwa.exception.AccountException;

public interface IAccountDao {

	AccountBean createAccount(AccountBean acc) throws AccountException;

	double showBalance(String mobNo) throws AccountException;

	double deposit(String mobNo, double amount) throws AccountException;

	double withdraw(String mobNo, double amount) throws AccountException;

	double fundTransfer(String srcMobNo, String destMobNo, double amount) throws AccountException;

	AccountBean printTransaction(String mobNo) throws AccountException;

}
