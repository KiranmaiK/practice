package net.antra.training.assignments.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDao {

    private static EntityManagerFactory entityManagerFactory;

    public BaseDao() throws Exception {
	try {
	    if (entityManagerFactory == null) {
		entityManagerFactory = Persistence.createEntityManagerFactory("net.antra.training.assignments");
	    }
	} catch (Exception e) {
	    throw e;
	}
    }

    public EntityManagerFactory getEntityManagerFactory() {
	return entityManagerFactory;
    }

}
