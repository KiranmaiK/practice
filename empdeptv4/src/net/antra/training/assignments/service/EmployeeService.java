package net.antra.training.assignments.service;

import java.util.List;

import net.antra.training.assignments.entity.Employee;

public interface EmployeeService {

    public void saveEmployee(String firstName, String lastName, String age) throws Exception;

    public List<Employee> getEmployees() throws Exception;
    
    public List<Employee> getEmployeesByIds(String[] employeeIds) throws Exception;

}
