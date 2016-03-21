package net.antra.training.assignments.service;

import java.util.List;

import net.antra.training.assignments.entity.Department;

public interface DepartmentService {

    public void saveDepartment(String departmentName, String departmentEmail, String[] employeeIds) throws Exception;

    public List<Department> getDepartments() throws Exception;

}
