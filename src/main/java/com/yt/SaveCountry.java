package com.yt;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveCountry {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		State state1 = new State();
		state1.setName("karnataka");
		state1.setPincode(740056);
		state1.setPopulation(150000);
		state1.setCM("basavaraj bommai");
		
		State state2 = new State();
		state2.setName("maharastra");
		state2.setPincode(740058);
		state2.setPopulation(120000);
		state2.setCM("eknath sindhe");
		
		State state3 = new State();
		state3.setName("california");
		state3.setPincode(740080);
		state3.setPopulation(115000);
		state3.setCM("andres manuel");
		
		State state4 = new State();
		state4.setName("mexico");
		state4.setPincode(740085);
		state4.setPopulation(170000);
		state4.setCM("gavin newsome");
		
		Country country1 = new Country();
		country1.setName("India");
		country1.setPin(950000);
		country1.setPopulation(700000);
		
		Country country2 = new Country();
		country2.setName("America");
		country2.setPin(560000);
		country2.setPopulation(900000);
		
		state1.setCountry(country1);
		state2.setCountry(country1);
		state3.setCountry(country2);
		state4.setCountry(country2);
		
		entityTransaction.begin();
		entityManager.persist(state1);
		entityManager.persist(state2);
		entityManager.persist(state3);
		entityManager.persist(state4);
		entityManager.persist(country1);
		entityManager.persist(country2);
		entityTransaction.commit();
		
//		create 4 states adding into 2 country 
//		update the population of the country based on Id = ?
//		get all the details of the country whose population is morethan 1.6 crore and based on CM (pin)
		
		
	}

}
