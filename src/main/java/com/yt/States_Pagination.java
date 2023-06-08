package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class States_Pagination {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select s from State s");
		
		query.setFirstResult(0); // index number starts from zero
		query.setMaxResults(3);  // no of records needed from zero + 1 (3 records will be displayed)
		
		List<State> list = query.getResultList();
		for (State state : list) {
			System.out.println(state.getName()+"     "+state.getCM());
		}
				
		/*
		 * karnataka  | basavaraj bommai
		 * maharastra | eknath sindhe
		 * california | andres manuel
		 * */
	}

}
