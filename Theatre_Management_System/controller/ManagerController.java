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

import com.project.Theatre_Management_System.dto.Manager;
import com.project.Theatre_Management_System.service.ManagerService;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;

	@PostMapping("/saveManager")
	public Manager saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@GetMapping("/fetchManagerById")
	public Manager fetchManagerById(@RequestParam int managerId) {
		return managerService.fetchManagerById(managerId);
	}

	@DeleteMapping("/deleteManagerById")
	public Manager deleteManagerById(@RequestParam int managerId) {
		return managerService.deleteManagerById(managerId);

	}

	@PutMapping("/updateManagerById")
	public Manager updateManagerById(@RequestParam int oldManagerId, @RequestBody Manager newManager) {
		newManager.setManagerId(oldManagerId);
		return managerService.saveManager(newManager);
	}

	@GetMapping("/fetchAllManager")
	public List<Manager> fetchAllManager() {
		return managerService.fetchAllManager();
	}
}
