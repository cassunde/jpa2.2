package br.com.cassunde.sample.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {

	@Produces
	public EntityManager criaEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		return factory.createEntityManager();
	}
}
