package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Address;
import com.project.Theatre_Management_System.dto.Employee;
import com.project.Theatre_Management_System.repo.EmployeeRepo;
@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepo employeeRepo;
	public Employee saveEmployee (Employee employee) {
		return  employeeRepo.save(employee);		
	}

	public Employee  fetchEmployeeById(int employeeId) {
		return employeeRepo.findById(employeeId).get();
	}

	public Employee  deleteEmployeeById(int employeeId) {
		Employee employee= employeeRepo.findById(employeeId).get();
		employeeRepo.delete(employee);
		return employee;
	}

	public Employee  updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		return employeeRepo.save(newEmployee);
	}

	public List<Employee > fetchAllEmployee () {
		return employeeRepo.findAll();
	}

}
