package io.vytas.blog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entity manager producer for test purposes only.
 * 
 * @author vytas.io
 *
 */
@ApplicationScoped
public class EntityManagerProducer {
	private static EntityManagerFactory emf;

	@Produces
	@RequestScoped
	protected EntityManager createEntityManager() {
		if (emf == null) {
			 emf = Persistence.createEntityManagerFactory("s01e07");
		}
		return emf.createEntityManager();
	}

	protected void closeEntityManager(@Disposes EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}
}
