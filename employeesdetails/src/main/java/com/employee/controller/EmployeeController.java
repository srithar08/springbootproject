package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.employee.entity.Employee;
import com.employee.pojo.EmployeePojo;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public EmployeePojo savaEmployee(@RequestBody EmployeePojo empPojo) {
		
		empPojo = empService.saveEmployee(empPojo);
		
		return empPojo;
	}

	@RequestMapping(value = "/allemployeesdata", method = RequestMethod.GET)
	public List<EmployeePojo> getAllEmpDetails()
	{
		List<EmployeePojo> empPojo = empService.getAllEmployees();
		
		return empPojo;
	}
	
	@RequestMapping(value = "/updateemp/{empid}", method=RequestMethod.PUT)
	public EmployeePojo updateEmp(@RequestBody EmployeePojo empPojo, @PathVariable("empid") String employeeId)
	{
		
		empPojo = empService.updateEmployee(employeeId, empPojo);
		
		return empPojo;
	}
	
	@RequestMapping(value = "/deleteemp/{empid}", method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("empid") Integer employeeId)
	{
		String result = empService.deleteEmployee(employeeId);
		return result;
	}
	
	
}
