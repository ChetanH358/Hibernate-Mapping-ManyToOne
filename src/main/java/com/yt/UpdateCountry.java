package com.yt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateCountry {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Country country = entityManager.find(Country.class, 2);
		country.setName("Russia");
		country.setPin(280000);
		country.setPopulation(500000);
		
		entityTransaction.begin();
		entityManager.merge(country);
		entityTransaction.commit();
		
//		|3|andres manuel|california|740080|115000|2 <-- before updation 
//		|3|andres manuel|california|740080|115000|2 <-- before updation 
		
//		State state = entityManager.find(State.class, 3);
//		state.setName("silicon valley");
//		
//		entityTransaction.begin();
//		entityManager.merge(state);
//		entityTransaction.commit();
		
		
	}

}
