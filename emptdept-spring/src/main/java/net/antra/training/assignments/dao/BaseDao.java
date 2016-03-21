package net.antra.training.assignments.dao;

import javax.persistence.EntityManagerFactory;

public interface BaseDao {
    public EntityManagerFactory getEntityManagerFactory();

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory);
}
