package com.employee.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.pojo.EmployeePojo;
import com.employee.repository.EmployeeRepository;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public EmployeePojo saveEmployee(EmployeePojo empPojo) {
		
		Employee emp = new Employee();
		emp.setEmpName(empPojo.getEmpName());
		emp.setEmpSalary(empPojo.getEmpSalary());
		emp.setEmpCity(empPojo.getEmpCity());
		
		emp = empRepo.save(emp);
		
		empPojo.setEmpId(emp.getEmpid());
		empPojo.setEmpName(emp.getEmpName());
		empPojo.setEmpCity(emp.getEmpCity());
		empPojo.setEmpSalary(emp.getEmpSalary());
		return empPojo;
	}

	@Override
	public List<EmployeePojo> getAllEmployees() {
		List<EmployeePojo> pojoList = new ArrayList<EmployeePojo>();
		
		List<Employee> empList = empRepo.findAll();
		
		for(Employee emp : empList)
		{
			EmployeePojo empPojo = new EmployeePojo();
			
			empPojo.setEmpId(emp.getEmpid());
			empPojo.setEmpName(emp.getEmpName());
			empPojo.setEmpSalary(emp.getEmpSalary());
			empPojo.setEmpCity(emp.getEmpCity());
			
			pojoList.add(empPojo);
			
		} 
		
		return pojoList;
	}

	@Override
	public EmployeePojo updateEmployee(String id, EmployeePojo empPojo) {
		Integer empid = Integer.valueOf(id);
		//Employee emp = empRepo.getById(empid);
		Employee emp = empRepo.findById(empid).get();
		emp.setEmpName(empPojo.getEmpName());
		emp.setEmpSalary(empPojo.getEmpSalary());
		emp.setEmpCity(empPojo.getEmpCity());
		
		
		
		emp = empRepo.save(emp);
		
		empPojo.setEmpId(emp.getEmpid());
		empPojo.setEmpName(emp.getEmpName());
		empPojo.setEmpCity(emp.getEmpCity());
		empPojo.setEmpSalary(emp.getEmpSalary());
		return empPojo;
	}

	@Override
	public String deleteEmployee(Integer id) {
		
		empRepo.deleteById(id);
		return "deleted successfully...";
	}

}
