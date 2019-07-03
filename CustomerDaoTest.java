package com.lti.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class CustomerDaoTest {

	@Test
	public void testAdd() {
		Customer c = new Customer();
		c.setName("uthu");
		c.setEmail("uthu@yahoo.com");
		c.setCity("Nagpur");
		
		CustomerDao dao = new CustomerDao();
		dao.databaseupdate(c);
	}
	
	@Test
	public void testFetch() {
		CustomerDao dao = new CustomerDao();
		List<Customer> cust = dao.databaseFetchAll();
	//	Customer cust = dao.databaseNundiThisukura(6); //please check the id in db
		Iterator<Customer> iterator = cust.iterator();{
			while(iterator.hasNext())
			{
				System.out.println(iterator.next().getName());
			}
		}
		
	//	System.out.println(cust.getName());
	//	System.out.println(cust.getEmail());
	//	System.out.println(cust.getCity());
	//	System.out.println(cust.getCity());
	}

	@Test
	public void testUpdate() {
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.databasefind(22); //please check the id in db
		cust.setCity("chennai");
		dao.databaseupdate(cust);
	}
	
	@Test
	public void fetchCustomerByEmail() {
	CustomerDao dao = new CustomerDao();
	List<Customer> cust = dao.fetchCustomerByEmail("gmail");
	Iterator<Customer> iterator = cust.iterator();{
		while(iterator.hasNext())
		{
			System.out.println(iterator.next().getName());
		}
	}
	}
}




