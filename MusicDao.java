package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MusicDao extends GenericDao{
public List<Song> fetchSongs(double id){
	EntityManagerFactory emf =null;
	EntityManager em = null;
	try {
		emf = Persistence.createEntityManagerFactory("oracleTest");
		em = emf.createEntityManager();	
		    	String ql="select a from Song a where a.album.id= :ids";
			    Query q=em.createQuery(ql);
		    	q.setParameter("ids", id);
				List<Song> list=q.getResultList();
				return list;
			   	}
		finally {
			    em.close();
				emf.close();
		}	
	
}
}
