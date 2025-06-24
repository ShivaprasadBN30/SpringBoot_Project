package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Address;
import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Employee;
import com.project.Theatre_Management_System.dto.Manager;
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo ;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	ScreenDao screenDao;
	public Branch saveBranch(Branch branch) {
		return  branchRepo.save(branch);		
	}

	public Branch fetchBranchById(int branchId) {
		return branchRepo.findById(branchId).get();
	}

	public Branch deleteBranchById(int branchId) {
		Branch branch= branchRepo.findById(branchId).get();
		branchRepo.delete(branch);
		return branch;
	}

	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		return branchRepo.save(newBranch);
	}

	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}
 
	public Branch addExistinhgManagerToExistingBranch(int branchId,int managerId) {
		Branch branch=fetchBranchById(branchId);
		Manager manager=managerDao.fetchManagerById(managerId);
		branch.setManager(manager);
		return saveBranch(branch);	
	}
	
	public Branch addExistingAddressToExistingBranch(int branchId,int addressId) {
		Branch branch=fetchBranchById(branchId);
		Address address=addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
		
	}
	
	public Branch addExistingEmploeeToExistingBranch(int employeeId,int branchId) {
		Branch branch=fetchBranchById(branchId);
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		List<Employee>list=branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	
	public Branch addNewEmployeeToExistingBranch(Employee newEmployee,int branchId) {
		Branch branch=fetchBranchById(branchId);
		List<Employee>list=branch.getEmployee();
		list.add(newEmployee);
		branch.setEmployee(list);
		return saveBranch(branch);
		
	}
	
	public Branch addExistingScreenToExistingBranch(int screenId,int branchId) {
		Branch branch=fetchBranchById(branchId);
		Screen screen=screenDao.fetchScreenById(screenId);
		List<Screen>list=branch.getScreen();
		list.add(screen);
		branch.setScreen(list);
		return saveBranch(branch);
	}
	
	public Branch addNewScreenToExistingBranch(Screen newScreen,int branchId) {
		Branch branch=fetchBranchById(branchId);
		List<Screen>list=branch.getScreen();
		list.add(newScreen);
		branch.setScreen(list);
		return saveBranch(branch);
		
	}
}
