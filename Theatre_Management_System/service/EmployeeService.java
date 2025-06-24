package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.EmployeeDao;
import com.project.Theatre_Management_System.dto.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	public Employee saveEmployee (Employee employee) {
		return  employeeDao.saveEmployee(employee);		
	}

	public Employee  fetchEmployeeById(int employeeId) {
		return employeeDao.fetchEmployeeById(employeeId);
	}

	public Employee  deleteEmployeeById(int employeeId) {
		return employeeDao.deleteEmployeeById(employeeId);
	}

	public Employee  updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		return employeeDao.saveEmployee(newEmployee);
	}

	public List<Employee > fetchAllEmployee () {
		return employeeDao.fetchAllEmployee();
	}

}
