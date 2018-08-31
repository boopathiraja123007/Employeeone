package edu.ksr.iet.dao;

import java.util.List;

import edu.ksr.edu.cls.Employee;



public interface EmployeeDao {

	public List<Employee> getEmployees(List<String> empList);
}
