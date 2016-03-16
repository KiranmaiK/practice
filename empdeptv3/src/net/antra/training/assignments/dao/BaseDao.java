package net.antra.training.assignments.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BaseDao {

    private static SessionFactory sessionFactory;

    public BaseDao() throws Exception {
	StandardServiceRegistry registry = null;
	try {
	    if (sessionFactory == null) {
		registry = new StandardServiceRegistryBuilder().configure() // configures settings from hibernate.cfg.xml
		        .build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	    }
	} catch (Exception e) {
	    StandardServiceRegistryBuilder.destroy(registry);
	    throw e;
	}
    }

    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

}
