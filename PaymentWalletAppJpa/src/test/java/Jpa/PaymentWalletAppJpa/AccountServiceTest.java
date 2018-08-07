package Jpa.PaymentWalletAppJpa;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.pwa.bean.AccountBean;
import com.cg.pwa.exception.AccountException;
import com.cg.pwa.service.AccountServiceImpl;

public class AccountServiceTest {

	@Test
	public void testCreateAccountName() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean("suma", "9740989654", "suma97@gmail.com",
				5000);

		try {
			accountService.createAccount(acc);

		} catch (AccountException e) {

			assertEquals("name should start with capital letter",
					e.getMessage());
		}
	}

	@Test
	public void testCreateAccountPhoneNum() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean("Suma", "974099654", "suma97@gmail.com", 5000);

		try {
			accountService.createAccount(acc);

		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}
	}

	@Test
	public void testCreateAccountEmail() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean("Suma", "9740989654", "", 5000);

		try {
			accountService.createAccount(acc);

		} catch (AccountException e) {

			assertEquals("enter valid email id", e.getMessage());
		}
	}

	@Test
	public void testCreateAccountBalance() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean("Suma", "9740989654", "suma97@gmail.com", 0);

		try {
			accountService.createAccount(acc);

		} catch (AccountException e) {
			assertEquals("minimum balance should be greater than 0",
					e.getMessage());
		}
	}
//error======delete
	/*@Test
	public void testCreateAccount() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean("Uma", "1234567890", "suma97@gmail.com",
				50000);

		try {
			System.out.println("ssssssssssssssss");
			accountService.createAccount(acc);
			
		} catch (AccountException e) {
			
			assertSame("No entity found for query", e.getMessage());
		}
	}*/

	// mob num validity
	@Test
	public void testShowBalanceMobNo() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("903645302");

		double amt = 0;
		try {
			amt = accountService.showBalance(acc.getMobileNum());
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

	

	@Test
	public void testShowBalance() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("9036453026");

		double amt = 0;
		try {
			amt = accountService.showBalance(acc.getMobileNum());
			assertEquals(10000, amt, 0.00);

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}

	}

	@Test
	public void testDepositMobNo() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("974059654");
		double amount = 1000;
		double amt = 0;
		try {
			amt = accountService.deposit(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

	/*@Test
	public void testDepositAccount() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("9740959654");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.deposit(acc.getMobileNum(), amount);

		} catch (AccountException e) {
			assertEquals("the mobile Number entered is invalid", e.getMessage());
			System.out.println("account************");

		}

	}*/

	@Test
	public void testDepositAmount() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("9740989654");
		double amount = 0;
		double bal = 0;
		try {
			bal = accountService.deposit(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("amount should be greater than 0", e.getMessage());

		}

	}

	/*@Test
	public void testDeposit() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("9740989654");
		double amount = 8000;
		double bal = 0;
		try {
			bal = accountService.deposit(acc.getMobileNum(), amount);
			assertEquals(13000, bal, 0.0);
		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}

	}*/

	@Test
	public void testWithdrawMobNo() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("805051332");
		double amount = 1000;
		double amt = 0;
		try {
			amt = accountService.withdraw(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

	/*@Test
	public void testWithdrawAccount() {

		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("8050512321");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.withdraw(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the mobile Number entered is invalid", e.getMessage());

		}

	}*/

	@Test
	public void testWithdrawAmount() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("8050513321");
		double amount = 0;
		double bal = 0;
		try {
			bal = accountService.withdraw(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("amount should be greater than 0", e.getMessage());

		}

	}

	@Test
	public void testWithdrawBalance() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("8050513321");
		double amount = 50000;
		double bal = 0;
		try {
			bal = accountService.withdraw(acc.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the amount entered should be less than balance",
					e.getMessage());

		}

	}

	@Test
	public void testWithdraw() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("8050513321");
		double amount = 500;
		double bal = 0;
		try {
			bal = accountService.withdraw(acc.getMobileNum(), amount);
			assertEquals(7500, bal, 0.00);

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}

	}

	@Test
	public void testFundTransferSrcMobNo() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc1 = new AccountBean();
		AccountBean acc2 = new AccountBean();
		acc1.setMobileNum("953559790");
		acc2.setMobileNum("8050020351");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

	@Test
	public void testFundTransferDestMobNo() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc1 = new AccountBean();
		AccountBean acc2 = new AccountBean();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("805002035");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("phone num should contain 10 digits", e.getMessage());

		}

	}

/*	@Test
	public void testFundTransferSrcAccount() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc1 = new AccountBean();
		AccountBean acc2 = new AccountBean();
		acc1.setMobileNum("9535596905");
		acc2.setMobileNum("8050020351");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the source mobile number is invalid", e.getMessage());

		}

	}

	@Test
	public void testFundTransferDestAccount() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc1 = new AccountBean();
		AccountBean acc2 = new AccountBean();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("8050010351");
		double amount = 1000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the destination mobile number is invalid",
					e.getMessage());

		}

	}*/

	@Test
	public void testFundTransferAmountBalance() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc1 = new AccountBean();
		AccountBean acc2 = new AccountBean();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("8050020351");
		double amount = 50000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("the amount entered should be less than balance",
					e.getMessage());

		}

	}

	@Test
	public void testFundTransferAmount() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc1 = new AccountBean();
		AccountBean acc2 = new AccountBean();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("8050020351");
		double amount = 0;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
		} catch (AccountException e) {
			assertEquals("amount should be greater than 0", e.getMessage());

		}

	}

	@Test
	public void testFundTransfer() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc1 = new AccountBean();
		AccountBean acc2 = new AccountBean();
		acc1.setMobileNum("9535597905");
		acc2.setMobileNum("8050020351");
		double amount = 5000;
		double bal = 0;
		try {
			bal = accountService.fundTransfer(acc1.getMobileNum(),
					acc2.getMobileNum(), amount);
			assertEquals(8000, bal, 0.00);
		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}

	}

	@Test
	public void testPrintTransactionMobValidate() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("805053321");
		try {
			accountService.printTransaction(acc.getMobileNum());

		} catch (AccountException e) {

			assertEquals("phone num should contain 10 digits", e.getMessage());

		}
	}

/*	@Test
	public void testPrintTransactionAccountValidate() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("8050523321");
		try {
			accountService.printTransaction(acc.getMobileNum());

		} catch (AccountException e) {

			assertEquals("the source mobile number 8050523321is invalid",
					e.getMessage());

		}
	}

	@Test
	public void testPrintTransaction() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("8050513321");
		try {
			acc = accountService.printTransaction(acc.getMobileNum());
			assertNotNull("", acc);

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}
	}*/

	@Test
	public void testPrintTransactionName() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("8050513321");
		try {
			acc = accountService.printTransaction(acc.getMobileNum());
			assertEquals("Manu", acc.getCustomerName());

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	public void testPrintTransactionBalance() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("8050513321");
		try {
			acc = accountService.printTransaction(acc.getMobileNum());
			assertEquals(7500, acc.getBalance(), 0.00);

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	public void testPrintTransactionEmail() {
		AccountServiceImpl accountService = new AccountServiceImpl();
		AccountBean acc = new AccountBean();

		acc.setMobileNum("8050513321");
		try {
			acc = accountService.printTransaction(acc.getMobileNum());
			System.out.println("email**************"+acc.getEmailId());
			assertEquals("manu97@gmail.com", acc.getEmailId());

		} catch (AccountException e) {
			System.out.println(e.getMessage());

		}
	}

}
