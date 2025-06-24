package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Manager;
import com.project.Theatre_Management_System.repo.ManagerRepo;

@Repository
public class ManagerDao {
	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}

	public Manager fetchManagerById(int managerId) {
		return managerRepo.findById(managerId).get();
	}

	public Manager deleteManagerById(int managerId) {
		Manager manager = managerRepo.findById(managerId).get();
		managerRepo.delete(manager);
		return manager;
	}

	public Manager updateManagerById(int oldManagerId, Manager newManager) {
		newManager.setManagerId(oldManagerId);
		return managerRepo.save(newManager);
	}

	public List<Manager> fetchAllManager() {
		return managerRepo.findAll();
	}
}
