package com.cg.pwa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.pwa.bean.AccountBean;
import com.cg.pwa.exception.AccountException;

public class AccountDaoImpl implements IAccountDao {
	EntityManagerFactory fac = Persistence.createEntityManagerFactory("hello");
	EntityManager em = fac.createEntityManager();

	public AccountBean createAccount(AccountBean acc) throws AccountException {
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
		return acc;
	}

	public double showBalance(String mobNo) throws AccountException {

		TypedQuery<AccountBean> query = em.createQuery("Select a from AccountBean a where a.mobileNum=?1",
				AccountBean.class);
		query.setParameter(1, mobNo);
		AccountBean acc = query.getSingleResult();
		if (acc==null) {
			throw new AccountException("the mobile Number entered is invalid");

		}
		return acc.getBalance();

	}

	public double deposit(String mobNo, double amount) throws AccountException {
		em.getTransaction().begin();
		try {
			double oldBal = showBalance(mobNo);
			double remainBal = oldBal + amount;
			Query query = em.createQuery("update AccountBean set balance=:bal where mobileNum=:m");

			query.setParameter("bal", remainBal);
			query.setParameter("m", mobNo);
			int res = query.executeUpdate();
			if (res != 0) {
				em.getTransaction().commit();
				return remainBal;
			} else {
				throw new AccountException("the mobile Number entered is invalid");
			}
		} catch (AccountException e) {
			throw new AccountException(e.getMessage());
		}

	}

	public double withdraw(String mobNo, double amount) throws AccountException {
		em.getTransaction().begin();
		try {
			if (amount < showBalance(mobNo)) {
				double remainBal = showBalance(mobNo) - amount;
				Query query = em.createQuery("update AccountBean set balance=:bal where mobileNum=:m");

				query.setParameter("bal", remainBal);
				query.setParameter("m", mobNo);
				int res = query.executeUpdate();
				em.getTransaction().commit();

				if (res != 0) {
					System.out.println("*******balance updated");
					return remainBal;
				} else {
					throw new AccountException("the destination mobile number is invalid");
				}
			} else {

				throw new AccountException("the amount entered should be less than balance");
			}
		} catch (AccountException e) {
			throw new AccountException(e.getMessage());
		}

	}

	public double fundTransfer(String srcMobNo, String destMobNo, double amount) throws AccountException {
		if(showBalance(destMobNo)!=0) {
		double balance = withdraw(srcMobNo, amount);
		deposit(destMobNo, amount);
		return balance;
		}else {
			throw new AccountException("the dest account doesnot exist ");
		}
	}

	public AccountBean printTransaction(String mobNo) throws AccountException {

		try {
			AccountBean acc = em.find(AccountBean.class, mobNo);

			if (!acc.equals(null)) {
				return acc;
			} else {
				throw new AccountException("the mobile Number entered is invalid");
			}
		} catch (AccountException e) {
			throw new AccountException(e.getMessage());
		}

	}

}
