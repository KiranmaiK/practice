package net.antra.training.assignments.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import net.antra.training.assignments.entity.Employee;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

    public EmployeeDaoImpl() throws Exception {
	super();
    }

    @Override
    public void save(Employee employee) throws Exception {
	Session session = null;
	try {
	    session = getSessionFactory().openSession();
	    session.beginTransaction();
	    session.save(employee);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    throw e;
	} finally {
	    // finally block used to close resources
	    if (session != null) {
		session.close();
	    }
	}
    }

    @Override
    public List<Employee> findAll() throws Exception {
	Session session = null;
	List<Employee> employees = null;
	try {
	    session = getSessionFactory().openSession();
	    session.beginTransaction();
	    employees = session.createQuery("from Employee").list();
	    session.getTransaction().commit();
	} catch (Exception e) {
	    throw e;
	} finally {
	    if (session != null) {
		session.close();
	    }
	}
	return employees;
    }

    @Override
    public List<Employee> findByIds(Integer[] employeeIds) throws Exception {
	Session session = null;
	List<Employee> employees = null;
	try {
	    session = getSessionFactory().openSession();
	    session.beginTransaction();

	    String hql = "from Employee where id in (:ids)";
	    Query query = session.createQuery(hql);
	    //query.setParameter("ids", employeeIds);
	    query.setParameterList("ids", employeeIds);
	    employees = query.list();
	    session.getTransaction().commit();
	} catch (Exception e) {
	    throw e;
	} finally {
	    if (session != null) {
		session.close();
	    }
	}
	return employees;
    }

}
