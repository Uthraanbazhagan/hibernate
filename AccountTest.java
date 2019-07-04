package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.Customer;
import com.lti.entity.Transaction;
import com.lti.service.AccountService;

public class AccountTest {

	@Test
	public void test() {
		AccountService as=new AccountService();
		Account acc=new Account();
		acc.setBalance(1000);
		acc.setName("Abc");
		acc.setType("savings");
		as.openAccount(acc);
	}
	@Test
	public void testwithDraw() {
		
		AccountService as=new AccountService();
		as.withdraw(142,100);
	}
	@Test
	public void testDeposit() {
		AccountService as=new AccountService();
		as.deposit(142, 1000);
	}
	@Test
	public void testBalance() {
		AccountService as=new AccountService();
	double bal=	as.checkBalance(142);
	System.out.println(bal);
	}
	@Test
	public void testTransfer() {
		AccountService as=new AccountService();
		as.transfer(142, 141,100);
	}
	@Test
	public void testTrans() {
	  AccountService as=new AccountService();
	  List<Transaction> list=  as.miniStatement(142);
	  for(Transaction c:list) {
	    	System.out.println(c.getTxno()+" "+c.getAmount()+" "+c.getType()+" "+c.getDate()); 	
	    }
		
	
	}
	@Test
	public void testMini() {
		AccountService as=new AccountService();
		  List<Account> list=  as.miniRetrieve(1000);
		  for(Account c:list) {
		  System.out.println(c.getAccno()+" "+c.getBalance());  	
		  }	
	}
	@Test
	public void testfetch() {
		AccountService as=new AccountService();
		  List<Account> list=  as.fetchit("Online",10);
		  for(Account c:list) {
		  System.out.println(c.getAccno()+" "+c.getBalance());  	
		  }
	
}
}
