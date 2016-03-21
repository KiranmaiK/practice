package net.antra.training.assignments.dao;

import java.util.List;

import javax.persistence.EntityManager;

import net.antra.training.assignments.entity.Department;

public class DepartmentDaoImpl extends BaseDaoImpl implements DepartmentDao {

    public DepartmentDaoImpl() throws Exception {
	super();
    }

    @Override
    public void save(Department department) throws Exception {
	EntityManager entityManager = null;
	try {
	    entityManager = getEntityManagerFactory().createEntityManager();
	    entityManager.getTransaction().begin();
	    entityManager.persist(department);
	    entityManager.getTransaction().commit();
	} catch (Exception e) {
	    throw e;
	} finally {
	    if (entityManager != null) {
		entityManager.close();
	    }
	}
    }

    @Override
    public List<Department> findAll() throws Exception {
	EntityManager entityManager = null;
	List<Department> departments = null;
	try {
	    entityManager = getEntityManagerFactory().createEntityManager();
	    entityManager.getTransaction().begin();
	    departments = entityManager.createQuery("from Department", Department.class).getResultList();
	    entityManager.getTransaction().commit();
	} catch (Exception e) {
	    throw e;
	} finally {
	    if (entityManager != null) {
		entityManager.close();
	    }
	}
	return departments;
    }

}
