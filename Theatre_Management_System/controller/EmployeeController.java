package com.project.Theatre_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Theatre_Management_System.dto.Employee;
import com.project.Theatre_Management_System.service.EmployeeService;
@RestController
public class EmployeeController {
	@Autowired
 EmployeeService employeeService;
	@PostMapping("/saveEmployee")
	public Employee saveEmployee (@RequestBody Employee employee) {
		return  employeeService.saveEmployee(employee);		
	}

	@GetMapping("/fetchEmployeeById")
	public Employee  fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}

	@DeleteMapping("/deleteEmployeeById")
	public Employee  deleteEmployeeById(@RequestParam int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}

	@PutMapping("/updateEmployeeById")
	public Employee  updateEmployeeById(@RequestParam int oldEmployeeId,@RequestBody  Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		return employeeService.saveEmployee(newEmployee);
	}

	@GetMapping("/fetchAllEmployee")
	public List<Employee> fetchAllEmployee () {
		return employeeService.fetchAllEmployee();
	}
}
