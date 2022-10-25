package com.te.employeemanagesystem.dao;

import com.te.employeemanagesystem.entity.Employee;

public interface MyDao {
	public Boolean create(Employee employee);

	public Employee authenticate(Employee employee);
	
	public Boolean update(Employee employee,String empId);
}
