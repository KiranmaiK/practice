package net.antra.training.assignments.service;

import java.util.ArrayList;
import java.util.List;

import net.antra.training.assignments.dao.EmployeeDao;
import net.antra.training.assignments.dao.EmployeeDaoImpl;
import net.antra.training.assignments.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void saveEmployee(String firstName, String lastName, String age) throws Exception {
	try {
	    Employee employee = new Employee();
	    employee.setFirstName(firstName);
	    employee.setLastName(lastName);
	    employee.setAge(Integer.parseInt(age));

	    EmployeeDao employeeDao = new EmployeeDaoImpl();
	    employeeDao.save(employee);
	} catch (Exception e) {
	    throw e;
	}
    }

    @Override
    public List<Employee> getEmployees() throws Exception {
	List<Employee> employees = null;
	try {
	    EmployeeDao employeeDao = new EmployeeDaoImpl();
	    employees = employeeDao.findAll();
	} catch (Exception e) {
	    throw e;
	}
	return employees;
    }

    @Override
    public List<Employee> getEmployeesByIds(String[] employeeIds) throws Exception {
	List<Employee> employees = null;
	try {
	    List<Integer> empIds = new ArrayList<Integer>();
	    for (int i = 0; i < employeeIds.length; i++) {
		empIds.add(Integer.valueOf(employeeIds[i]));
	    }

	    EmployeeDao employeeDao = new EmployeeDaoImpl();
	    employees = employeeDao.findByIds(empIds);
	} catch (Exception e) {
	    throw e;
	}
	return employees;
    }

}
