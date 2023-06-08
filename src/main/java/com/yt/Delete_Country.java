package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete_Country {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

//		In ManyToOne mapping we can delete the states directly by writing hibernate query 
		
//		Query query = entityManager.createQuery("select s from State s where s.name = ?1");
//		query.setParameter(1, "maharastra");
//		List<State> details = query.getResultList();

//		|2|eknath sindhe|maharastra|740058|120000|1|  <-- this got deleted 
//		|1|basavaraj bommai|karnataka|740056|150000|1| <-- this got deleted after maharastra

//		for (State ele : details) {
//			entityTransaction.begin();
//			entityManager.remove(ele);
//			entityTransaction.commit();
//
//		}

//		System.out.println("********************************************");

		Query query = entityManager.createQuery("select c from Country c where c.name = ?1");
		query.setParameter(1, "America");
		List<Country> details = query.getResultList();

		/*
		 * In ManyToOne Mapping we cannot delete country directly. In ManyToOne Mapping
		 * we can delete states directly and when all states which are having foregin
		 * key with country get deleted then we can easily delete country
		 * 
		 * In this case 
		 * parent table is -> state
		 * child table is -> country
		 * Foreign key (country_id) references country(id)
		 * 
		 * first we need to delete all records of child table , then only we able to delete parent table
		 */

		for (Country ele : details) {
//			getting all details of the state whose country_id is 1;
			Query query_state = entityManager.createQuery("select s from State s where country_id = ?1");
			query_state.setParameter(1, ele.getId());
			List<State> state = query_state.getResultList();
			for (State state_ele : state) {
//				deleting all the states which are having the country_id = 1;
				entityTransaction.begin();
				entityManager.remove(state_ele);
				entityTransaction.commit();
			}
//			once all states got deleted ,now delete country
			entityTransaction.begin();
			entityManager.remove(ele);
			entityTransaction.commit();
//			once done with deletion of the country immeditaly exit the loop
			break;
		}

	}

}
