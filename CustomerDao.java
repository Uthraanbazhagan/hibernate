package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class CustomerDao {
	
	/*public void databaseAdd(Customer customer) {
		
		EntityManagerFactory emf  =null;
		EntityManager em=null;
		try {	
		emf=	Persistence.createEntityManagerFactory("oracle-pu");
		em= emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		 tx.begin();
	
		 em.persist(customer);
		 
		 tx.commit();
		}
		finally {
		 em.close();
		 emf.close();
		}
	}*/
	 public Customer databasefind(int custId) {
			 EntityManagerFactory  emf =null;
				EntityManager em=null;
				try {
					 emf=Persistence.createEntityManagerFactory("oracle-pu");
					 em = emf.createEntityManager();
			 
			 //find method generates select query
			 Customer c = em.find(Customer.class, custId);
			 return c;
				}
				finally {
			 em.close();
			 emf.close();
				}
			 
		 }
		 
		 public void databaseupdate(Customer customer) {
			 EntityManagerFactory emf  = null;
				EntityManager em=null;
				try {
						emf=Persistence.createEntityManagerFactory("oracle-pu");
						em= emf.createEntityManager();
				
				EntityTransaction tx = em.getTransaction();
				 tx.begin();
			
				 em.merge(customer); //merge method updates the table
				 
				 tx.commit();
				}
				finally {
				 em.close();
				 emf.close();
		 }
		 }
		 
		 
		 public List<Customer> databaseFetchAll() {
			 EntityManagerFactory  emf = null;
			 EntityManager em = null;
			 try {
				 
				emf=	 Persistence.createEntityManagerFactory("oracle-pu");
			em= emf.createEntityManager();
			 
			 //introducing JP-QL/HQL
			 //c is the alias fro classname (select c --> is equal to select *)
			 Query q = em.createQuery("select c from Customer c"); //select * from ClassName c (or) select c.name from className
			 List<Customer> list = q.getResultList();
			 return list;
			 }
			 finally {
			 em.close();
			 emf.close();
			 }
			 
		 }
		 
		 public List<Customer> fetchCustomerByEmail(String email) {
			 EntityManagerFactory  emf =null;
			 EntityManager em =null;
				try {
				emf=	Persistence.createEntityManagerFactory("oracle-pu");
				
			em=  emf.createEntityManager();

			 Query q = em.createQuery("select c from Customer c where c.email like :em");
			 q.setParameter("em","%" + email + "%");
			// q.setParameter(1, email); in case '?' is used instead of 'em' in the query.(%@?.%)
			 
			 List<Customer> list = q.getResultList();
			 return list;
				}
				finally {
			 em.close();
			 emf.close();
				}
			 
		 }
}
