package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;
import com.lti.entity.GenericDao;
import com.lti.entity.Order;
import com.lti.entity.Payment;

import oracle.net.aso.o;

public class OrderTest {

	@Test
	public void placeOrder() {
		GenericDao dao = new GenericDao();
		Customer cust = (Customer) dao.fetchById(Customer.class, 42);
		
		Order o = new Order();
		o.setOrderDate(new Date());
		o.setId(14);
		o.setAmount(400);
		o.setCustomer(cust);
		dao.save(o); 
	}
	
	
	@Test
	public void testFetchAll() {
		GenericDao dao= new GenericDao();
		List<Order> orders=dao.fetchAll(Order.class);
    for(Order order : orders) {
    	System.out.println(order.getId());
    	System.out.println(order.getAmount());
    	System.out.println(order.getOrderDate());
    	System.out.println(order.getCustomer().getId());
    	System.out.println("*********************************");
    }
	}
	

	
}
