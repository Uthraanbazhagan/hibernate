package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class GenericDao {

	 public void save(Object object) {
		 EntityManagerFactory emf  = null;
			EntityManager em=null;
			try {
					emf=Persistence.createEntityManagerFactory("oracle-pu");
					em= emf.createEntityManager();
			
			EntityTransaction tx = em.getTransaction();
			 tx.begin();
		
			 em.merge(object); //merge method updates the table
			 
			 tx.commit();
			}
			finally {
			 em.close();
			 emf.close();
	 }
	 }
	 public Object fetchbyId(Class classname,Object id) {
		 EntityManagerFactory  emf =null;
		 EntityManager em=null;
			try {
				 emf=Persistence.createEntityManagerFactory("oracle-pu");
				 em = emf.createEntityManager();
		 
		 //find method generates select query
		 Object obj = em.find(classname, id);
		 return obj;
			}
			finally {
		 em.close();
		 emf.close();
			}
		 
	 }
	 public <E> List<E> databaseFetchAll(Class<E> clazz) {
		 EntityManagerFactory  emf = null;
		 EntityManager em = null;
		 try {
			 
			emf=	 Persistence.createEntityManagerFactory("oracle-pu");
			em= emf.createEntityManager();
		 
		 //introducing JP-QL/HQL
		 //c is the alias fro classname (select c --> is equal to select *)
		 Query q = em.createQuery("select obj from "+clazz.getName()+" as obj");//select * from ClassName c (or) select c.name from className
		 
		 List<E> list = q.getResultList();
		 return list;
		 }
		 finally {
		 em.close();
		 emf.close();
		 }
		 
	 }



}
