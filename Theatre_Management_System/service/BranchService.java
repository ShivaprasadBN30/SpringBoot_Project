package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.BranchDao;
import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Employee;
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.util.ResponseStructure;

@Service
public class BranchService {
	
	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure< Branch>responseStructure;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setMessage("sucessfully inserted");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		responseStructure.setMessage("Got the details");
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setData(branchDao.fetchBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		responseStructure.setMessage("Deleted");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.deleteBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId, Branch newBranch) {
		responseStructure.setMessage("Successfully Updated");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	public List<Branch> fetchAllBranch() {
		return branchDao.fetchAllBranch();
	}
	public ResponseEntity<ResponseStructure<Branch>> addExistinhgManagerToExistingBranch(int branchId,int managerId) {
		responseStructure.setMessage("Manager added sucessfully");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistinhgManagerToExistingBranch(branchId, managerId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int branchId,int addressId) {
		responseStructure.setMessage("Address added sucessfully");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(branchId, addressId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Branch>> addExistingEmploeeToExistingBranch(int employeeId,int branchId) {
		responseStructure.setMessage("Address added sucessfully");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData( branchDao.addExistingEmploeeToExistingBranch(employeeId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(Employee newEmployee,int branchId) {
		responseStructure.setMessage("Address added sucessfully");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData( branchDao.addNewEmployeeToExistingBranch(newEmployee, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> addExistingScreenToExistingBranch(int screenId,int branchId) {
		responseStructure.setMessage("Address added sucessfully");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData( branchDao.addExistingScreenToExistingBranch(screenId, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Branch>> addNewScreenToExistingBranch(Screen newScreen,int branchId) {
		responseStructure.setMessage("Address added sucessfully");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addNewScreenToExistingBranch(newScreen, branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
	}
}
