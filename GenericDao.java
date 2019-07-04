package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDao {

	// CODE FOR INSERTING & UPDATING
	public void save(Object obj) {
	EntityManagerFactory emf =null;
	EntityManager em = null;
	try {
		emf = Persistence.createEntityManagerFactory("oracleTest");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			em.merge(obj);//merge method is used for insert n update both
			tx.commit();
	}
	finally {
			em.close();
			emf.close();
	}
}
	
	
	public Object fetchById(Class classname, Object id) {
		EntityManagerFactory emf =null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			
			Object obj=em.find(classname,id);
			return obj;
		}
		finally {
		em.close();
		emf.close();
		
		}
	}
	
	//List <?> --> '?' indicates it can be a list of any object (i.e Customer or Order )
	// Using generics so we dont have to typecast in OrderTest.java
	public <E> List<E> fetchAll(Class<E> clazz) { //use of Generics
		EntityManagerFactory emf =null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			
			Query q=em.createQuery("Select obj from " + clazz.getName() + " as obj");
			List<E> list=q.getResultList();
			return list;
					}
	finally {
		    em.close();
			emf.close();
	}
		}


}
