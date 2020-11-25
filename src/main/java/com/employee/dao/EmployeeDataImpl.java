package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
@Qualifier("EmployeeDao")
public class EmployeeDataImpl implements EmployeeDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addEmployee(Employee employee) {
		
		jdbcTemplate.update("insert into employee(first_name,last_name,departement) values(?,?,?)",
				employee.getFirstName(),employee.getLastName(),employee.getDepartement());
		
		System.out.println("employee data added");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editEmployee(Employee employee,String name) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update employee set last_name=?,departement=? where first_name=?",
				employee.getLastName(),employee.getDepartement(),employee.getFirstName());

		System.out.println("employee data updated");
	}

	@Override
	public void deleteEmployee(Employee employee,String name) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from employee where first_name=?",name);

		System.out.println("employee data deleted");
		
	}

	@Override
	public Employee Find(String name) {
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Employee employee =(Employee) jdbcTemplate.queryForObject("select first_name,last_name,departement from employee where first_name=?",
				new Object[] {name},new BeanPropertyRowMapper(Employee.class));
		return employee;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAll() {
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Employee> employee =jdbcTemplate.query("select first_name,last_name,departement from employee",
				new BeanPropertyRowMapper(Employee.class));
		System.out.println(employee);
		return employee;
	
	}
}
