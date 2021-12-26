package com.employee.service;

import java.util.List;

import com.employee.pojo.EmployeePojo;

public interface EmployeeService {
	
	EmployeePojo saveEmployee(EmployeePojo empPojo);
	List<EmployeePojo> getAllEmployees();
	EmployeePojo updateEmployee(String id,EmployeePojo empPojo);
	String deleteEmployee(Integer id);
}
