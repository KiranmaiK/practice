package net.antra.training.assignments.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDaoImpl implements BaseDao {

	private EntityManagerFactory entityManagerFactory;

	public BaseDaoImpl() throws Exception {

	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

}
