package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CustomerDao {

	/*
	public void databaseMeAddKaro(Customer customer) {
		EntityManagerFactory emf =null;
		EntityManager em = null;
		try {
		 emf = Persistence.createEntityManagerFactory("oracleTest");
		//load/create entity manager
		em = emf.createEntityManager();
		//start a transaction
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//insert/update/delete/select
		em.persist(customer);
		tx.commit();
		}
		finally {
		em.close();
		emf.close();
		}
	}
	*/
	
	public Customer fetchById(int custId) {
		EntityManagerFactory emf =null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			Customer c=em.find(Customer.class, custId);
			return c;
		}
		finally {
		em.close();
		emf.close();
		
		}
	}
	
	
	public void insertOrUpdate(Customer customer) {
	EntityManagerFactory emf =null;
	EntityManager em = null;
	try {
		emf = Persistence.createEntityManagerFactory("oracleTest");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.merge(customer);//merge method used for insert n update both
			tx.commit();
	}
	finally {
			em.close();
			emf.close();
	}
}
	
	
	
public List<Customer> fetchAll() {
	EntityManagerFactory emf =null;
	EntityManager em = null;
	try {
		emf = Persistence.createEntityManagerFactory("oracleTest");
		em = emf.createEntityManager();
		//introducing JP-QL/HQL
		Query q=em.createQuery("select c from Customer c where c.city='hennai'");
		List<Customer> list=q.getResultList();
		return list;
	}
finally {
	    em.close();
		emf.close();
}
	}



public List<Customer> fetchCustomerByEmail(String email) {
	EntityManagerFactory emf =null;
	EntityManager em = null;
	try {
		emf = Persistence.createEntityManagerFactory("oracleTest");
		em = emf.createEntityManager();
	//introducing JP-QL/HQL
	Query q=em.createQuery("select c from Customer c where c.email like :em");
	q.setParameter("em", "%"+email+"%");
	
	//	Query q=em.createQuery("select c from Customer c where c.email like %?%");
	//q.setParameter(1, email);//instead of :em use? in the above query
	List<Customer> list=q.getResultList();
	return list;
}
	finally {
    em.close();
	emf.close();
	}
}
}