package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeedao;

	@Override
	public void addEmployee(Employee employee) {
		employeedao.addEmployee(employee);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editEmployee(Employee employee,String name) {
		// TODO Auto-generated method stub
		employeedao.editEmployee(employee,name);
		
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeedao.findAll();
	}

	@Override
	public void deleteEmployee(Employee employee, String name) {
		// TODO Auto-generated method stub
		employeedao.deleteEmployee(employee, name);
		
	}

	@Override
	public Employee Find(String name) {
		// TODO Auto-generated method stub
		return employeedao.Find(name);
	}
}
