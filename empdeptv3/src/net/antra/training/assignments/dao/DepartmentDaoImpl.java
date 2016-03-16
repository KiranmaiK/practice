package net.antra.training.assignments.dao;

import java.util.List;

import org.hibernate.Session;

import net.antra.training.assignments.entity.Department;

public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {

    public DepartmentDaoImpl() throws Exception {
	super();
    }

    @Override
    public void save(Department department) throws Exception {
	Session session = null;
	try {
	    session = getSessionFactory().openSession();
	    session.beginTransaction();
	    session.save(department);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    throw e;
	} finally {
	    session.close();
	}
    }

    @Override
    public List<Department> findAll() throws Exception {
	Session session = null;
	List<Department> departments = null;
	try {
	    session = getSessionFactory().openSession();
	    session.beginTransaction();
	    departments = session.createQuery("from Department").list();
	    session.getTransaction().commit();
	} catch (Exception e) {
	    throw e;
	} finally {
	    if (session != null) {
		session.close();
	    }
	}
	return departments;
    }

}
