package com.employee.service;
import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	
	
	public List<Employee> findAll();
	public void deleteEmployee(Employee employee, String name);
	public Employee Find(String name);
	void editEmployee(Employee employee, String name);
	

}
