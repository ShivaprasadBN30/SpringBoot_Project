package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.ManagerDao;
import com.project.Theatre_Management_System.dto.Manager;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;

	public Manager saveManager(Manager manager) {
		return managerDao.saveManager(manager);
	}

	public Manager fetchManagerById(int managerId) {
		return managerDao.fetchManagerById(managerId);
	}

	public Manager deleteManagerById(int managerId) {
		return managerDao.deleteManagerById(managerId);
		
	}

	public Manager updateManagerById(int oldManagerId, Manager newManager) {
		newManager.setManagerId(oldManagerId);
		return managerDao.saveManager(newManager);
	}

	public List<Manager> fetchAllManager() {
		return managerDao.fetchAllManager();
	}
}
