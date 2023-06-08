package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetAllByCountry {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
//		Country country = entityManager.find(Country.class, 1);
//		System.out.println(" the country id is "+country.getId());
//		System.out.println(" the country name is "+country.getName());
//		System.out.println(" the country pin is "+country.getPin());
//		System.out.println(" the country poulation is "+country.getPopulation());
		
//		query is an interface present in javax.persistence package
		
//		we should write in hibenate query language 
		Query query = entityManager.createQuery("select c from Country c where c.population >= ?1 and c.pin >= ?2");
		query.setParameter(1, 100000);
		query.setParameter(2, 500000);
//		list is an interface present in java.util package
		
		List<Country> country = query.getResultList();
		for (Country ele : country) {
		System.out.println("****************************************");
		
		System.out.println(" the country id is "+ele.getId());
		System.out.println(" the country name is "+ele.getName());
		System.out.println(" the country pin is "+ele.getPin());
		System.out.println(" the country poulation is "+ele.getPopulation());
			
		System.out.println("****************************************");
		}

	}

}
