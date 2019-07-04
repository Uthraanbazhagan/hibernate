package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.GenericDao;
import com.lti.entity.Order;
import com.lti.entity.Payment;

public class PaymentTest {

	@Test
	public void test() {
		GenericDao dao = new GenericDao();
		//Order order= (Order) dao.fetchById(Order.class,61);

		Payment p = new Payment();
		p.setAmount(666);;
		p.setMod("DebitCard");
		//p.setId(1000);
		p.setStatus("success");
		dao.save(p);
	}
	
	@Test
	public void link() {
		GenericDao dao=new GenericDao();
		Order o=(Order) dao.fetchById(Order.class, 64);
		Payment p=(Payment) dao.fetchById(Payment.class,101 );
		o.setPayment(p);
		dao.save(o);
	}
}
	
	

