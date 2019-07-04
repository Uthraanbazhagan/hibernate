package com.lti.service;

import java.util.Date;
import java.util.List;

import com.lti.entity.Account;
import com.lti.entity.AccountDao;
import com.lti.entity.Transaction;

public class AccountService {

	public void openAccount(Account acc) {
		AccountDao dao = new AccountDao();
		dao.save(acc);
	}
	public void withdraw(long acno,double amount) {
		
		Transaction tx=new Transaction();
		AccountDao dao=new AccountDao();
		Account ac=(Account)dao.fetchById(Account.class, acno);
		System.out.println(ac.getBalance());
		double bal=ac.getBalance();
		if(ac.getBalance()>=amount) {
			ac.setBalance(ac.getBalance()-amount);
			dao.save(ac);
			tx.setAccount(ac);
			tx.setAmount(-amount);
			tx.setDate(new Date());
			tx.setType("Online");	
			dao.save(tx);
		}
		
	}
	public void deposit(long acno,double amount) {
		Transaction tx=new Transaction();
		AccountDao dao=new AccountDao();
		Account ac=(Account)dao.fetchById(Account.class, acno);
		ac.setBalance(ac.getBalance()+amount);
		dao.save(ac);
		tx.setAccount(ac);
		tx.setAmount(amount);
		tx.setDate(new Date());
		tx.setType("Online");	
		dao.save(tx);
	
		
	}
	public void transfer(long fromAcno,long toAcno,double amount) {
		AccountService as=new AccountService();
		as.withdraw(fromAcno, amount);
		as.deposit(toAcno, amount);
		
		
	}
	public double checkBalance(long acno) {
		AccountDao dao=new AccountDao();
		Account ac=(Account)dao.fetchById(Account.class, acno);
		
		return ac.getBalance();
	}
	public List<Transaction> miniStatement(long acno){
		AccountDao dao=new AccountDao();
		
		List<Transaction> list=dao.fetchMiniStatement(acno);
		return list  ;
	}
	public List<Account> miniRetrieve(double no){
		AccountDao dao=new AccountDao();
		
		List<Account> list=dao.mini(no);
		
		return list  ;
	}
	public List<Account> fetchit(String type,double amount){
		AccountDao dao=new AccountDao();
		
		List<Account> list=dao.fetchAccount(type,amount);
		
		return list  ;
	}
}
