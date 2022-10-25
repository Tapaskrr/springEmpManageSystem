package com.te.employeemanagesystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
@Id
private String empId;
private String empName;
private String empMail;
private String empPwd;
	
	
}
