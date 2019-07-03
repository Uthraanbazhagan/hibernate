package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.Order;
import com.lti.entity.Payment;

public class GenericDaoTest {

	
	@Test
	public void TestAdd() {
		Order order=new Order();
		GenericDao gdao=new GenericDao();
		Customer c=(Customer)gdao.fetchbyId(Customer.class, 44);
		order.setOrderDate(new Date());
		order.setAmount(4000);
		order.setCustomer(c);
		gdao.save(order);

		
	}

	@Test
	public void TestFetch() {
		GenericDao dao=new GenericDao();
		List<Order> order =dao.databaseFetchAll(Order.class);
	//	Customer cust = dao.databaseNundiThisukura(6); //please check the id in db
		Iterator<Order> iterator = order.iterator();{
			while(iterator.hasNext())
			{
				Order or=iterator.next();
				System.out.println(or.getId()+" "+or.getOrderDate()+" "+or.getAmount()+" "+or.getCustomer().getName());
			  
			}
		}
		
	}
	@Test
	public void TestAddPayment() {
		Payment p=new Payment();
		GenericDao dao=new GenericDao();
		//Order or=(Order)dao.fetchbyId(Order.class,83);
	
		p.setAmount(3000);
		p.setPmode("Online");
	
		dao.save(p);
		
	}
	@Test
	public void LinkPayment() {
		
		GenericDao dao=new GenericDao();
	    Payment p=(Payment)dao.fetchbyId(Payment.class, 121);   
		Order o=(Order)dao.fetchbyId(Order.class,101);
		o.setPayment(p);
		dao.save(o);
	}






}


