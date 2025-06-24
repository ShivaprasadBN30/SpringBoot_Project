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

import com.project.Theatre_Management_System.dto.Food;
import com.project.Theatre_Management_System.dto.Ticket;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.service.ViewerService;

@RestController
public class ViewerController {
	@Autowired
	ViewerService viewerService;
	
	@PostMapping("/saveViewer")
	public Viewer saveViewer(@RequestBody Viewer viewer ) {
		return viewerService.saveViewer(viewer);
	}

	@GetMapping("/fetchViewerById")
	public Viewer fetchViewerById(@RequestParam int viewerId) {
		return viewerService.fetchViewerById(viewerId);
	}

	@DeleteMapping("/deleteViewerById")
	public Viewer  deleteViewerById(@RequestParam int viewerId) {
		return viewerService.deleteViewerById(viewerId);
		
	}

	@PutMapping("/updateViewerById")
	public Viewer  updateViewerById(@RequestParam int oldViewerId,@RequestBody Viewer  newViewer) {
		newViewer .setViewerId(oldViewerId);
		return viewerService.saveViewer(newViewer);
	}

	@GetMapping("/fetchAllViewer")
	public List<Viewer> fetchAllViewer() {
		return viewerService.fetchAllViewer();
	}
	
	@PutMapping("/addExistingTicketToExistingViewer")
	public Viewer addExistingTicketToExistingViewer(@RequestParam  int ticketId,@RequestParam  int viewerId) {
		return viewerService.addExistingTicketToExistingViewer(ticketId, viewerId);
	}
	
	@PutMapping("/addNewTicketToExistingViewer")
	public Viewer addNewTicketToExistingViewer(@RequestBody Ticket newTicket,@RequestParam  int viewerId) {
		return viewerService.addNewTicketToExistingViewer(newTicket, viewerId);
	}
	
	@PutMapping("/addExistingFoodToExistingViewer")
	public Viewer addExistingFoodToExistingViewer(@RequestParam  int foodId,@RequestParam  int viewerId) {
		return viewerService.addExistingFoodToExistingViewer(foodId, viewerId);
	}
	
	@PutMapping("/addNewFoodToExistingViewer")
	public Viewer addNewFoodToExistingViewer(@RequestBody Food newFood,@RequestParam  int viewerId) {
		return viewerService.addNewFoodToExistingViewer(newFood, viewerId);
	}
}
