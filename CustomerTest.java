package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;

public class CustomerTest {
	
	@Test
	public void testInsert() {
		//fail("Not yet implemented");
		Customer c =new Customer();
		c.setName("keerti");
		c.setEmail("keertishreena@gmail.com");
		c.setCity("nagpur");
		CustomerDao dao = new CustomerDao();
		dao.insertOrUpdate(c); //inserting using merge method
	}
	
	@Test
	public void testFetch() {
		CustomerDao dao = new CustomerDao();
		Customer cust=	dao.fetchById(1);
	System.out.println(cust.getName());
	System.out.println(cust.getEmail());
	System.out.println(cust.getCity());
	}
	@Test
	public void testUpdate() {
		//Customer c=new Customer();
		CustomerDao dao=new CustomerDao();
		Customer cust=dao.fetchById(14);
		cust.setCity("chennai");
		dao.insertOrUpdate(cust);// updating using merge method
		
		
	}
	@Test
	public void testFetchAll() {
		CustomerDao dao = new CustomerDao();
		List<Customer> cust=	dao.fetchAll();
    for(Customer c:cust) {
    	System.out.println(c.getName());
    }
	}
	
	
	@Test
	public void testFetchByEmail() {
		CustomerDao dao = new CustomerDao();
		List<Customer> cust=	dao.fetchCustomerByEmail("gmail");
    for(Customer c:cust) {
    	System.out.println(c.getName());
    }
	}
	
}
