package net.antra.training.assignments.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.antra.training.assignments.entity.Employee;

public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl() throws Exception {
		super();
	}

	public void save(Employee employee) throws Exception {
		EntityManager entityManager = null;
		try {
			entityManager = getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(employee);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	public List<Employee> findAll() throws Exception {
		EntityManager entityManager = null;
		List<Employee> employees = null;
		try {
			entityManager = getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
			employees = entityManager.createQuery("from Employee", Employee.class).getResultList();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return employees;
	}

	public List<Employee> findByIds(List<Integer> employeeIds) throws Exception {
		EntityManager entityManager = null;
		List<Employee> employees = null;
		try {
			entityManager = getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("SELECT e from Employee e where e.id in :ids");
			query.setParameter("ids", employeeIds);
			employees = query.getResultList();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return employees;
	}

}
