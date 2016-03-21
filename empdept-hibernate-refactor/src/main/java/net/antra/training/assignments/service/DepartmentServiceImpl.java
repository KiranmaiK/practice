package net.antra.training.assignments.service;

import java.util.List;

import net.antra.training.assignments.dao.DepartmentDao;
import net.antra.training.assignments.dao.DepartmentDaoImpl;
import net.antra.training.assignments.entity.Department;
import net.antra.training.assignments.entity.Employee;

public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public void saveDepartment(String departmentName, String departmentEmail, String[] employeeIds) throws Exception {
	try {
	    Department department = new Department();
	    department.setDepartmentName(departmentName);
	    department.setDepartmentEmail(departmentEmail);

	    EmployeeService employeeService = new EmployeeServiceImpl();
	    List<Employee> employees = employeeService.getEmployeesByIds(employeeIds);
	    for (Employee employee : employees) {
		employee.setDepartment(department);
	    }

	    DepartmentDao departmentDao = new DepartmentDaoImpl();
	    departmentDao.save(department);
	} catch (Exception e) {
	    throw e;
	}
    }

    @Override
    public List<Department> getDepartments() throws Exception {
	List<Department> departments = null;
	try {
	    DepartmentDao departmentDao = new DepartmentDaoImpl();
	    departments = departmentDao.findAll();
	} catch (Exception e) {
	    throw e;
	}
	return departments;
    }

}
