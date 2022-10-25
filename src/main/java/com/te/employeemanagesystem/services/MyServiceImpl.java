package com.te.employeemanagesystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.employeemanagesystem.dao.MyDao;
import com.te.employeemanagesystem.entity.Employee;
import com.te.employeemanagesystem.exception.MyException;

@Service
public class MyServiceImpl implements MyService {
	@Autowired
	private MyDao myDao;

	@Override
	public Boolean create(Employee employee) {
		if(employee.getEmpId().startsWith("tys")) {
			return myDao.create(employee);
		}
		else {
			throw new MyException("id is not started with tys");
		}
		
		
		
	}

	@Override
	public Employee authenticate(Employee employee) {
		if(employee.getEmpId().startsWith("tys")) {
			Employee authenticate = myDao.authenticate(employee);
			if(authenticate!=null) {
				return authenticate;
		}
		else {
			throw new MyException("dao went wrong from service");
		}
	}else {
		throw new MyException("id is not started with tys");
	}
}

	@Override
	public Boolean update(Employee employee,String empId) {
		
			return myDao.update(employee,empId);
		
	
		
		
	}
}
