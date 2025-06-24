package com.project.Theatre_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Employee;
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.service.BranchService;
import com.project.Theatre_Management_System.util.ResponseStructure;

@RestController
public class BranchController {
	@Autowired
	BranchService branchService;
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody  Branch branch) {
		return  branchService.saveBranch(branch);		
	}

	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}
	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);	
	}

	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int oldBranchId,@RequestBody  Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}
	
    @GetMapping("/fetchAllBranch")
	public List<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}

    @PutMapping("/addExistinhgManagerToExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> addExistinhgManagerToExistingBranch(@RequestParam int branchId,@RequestParam int managerId) {
    	return branchService.addExistinhgManagerToExistingBranch(branchId, managerId);
    }
    @PutMapping("/addExistingAddressToExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(@RequestParam int branchId,@RequestParam int addressId) {
	return	branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}
    
    @PutMapping("/addExistingEmploeeToExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> addExistingEmploeeToExistingBranch(@RequestParam int employeeId,@RequestParam int branchId) {
		return branchService.addExistingEmploeeToExistingBranch(employeeId, branchId);
	}
	
    @PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(@RequestBody Employee newEmployee,@RequestParam int branchId) {
		return branchService.addNewEmployeeToExistingBranch(newEmployee, branchId);
	}
    
    @PutMapping("/addExistingScreenToExistingBranch")
    public ResponseEntity<ResponseStructure<Branch>> addExistingScreenToExistingBranch(int screenId,int branchId) {
		return branchService.addExistingScreenToExistingBranch(screenId, branchId);
	}
    @PutMapping("/addNewScreenToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewScreenToExistingBranch(Screen newScreen,int branchId) {
		return branchService.addNewScreenToExistingBranch(newScreen, branchId);
	}
}
