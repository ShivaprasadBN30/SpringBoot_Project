package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.ViewerDao;
import com.project.Theatre_Management_System.dto.Food;
import com.project.Theatre_Management_System.dto.Ticket;
import com.project.Theatre_Management_System.dto.Viewer;

@Service
public class ViewerService {
	@Autowired
	ViewerDao viewerDao;
	
	
	public Viewer saveViewer(Viewer viewer ) {
		return viewerDao.saveViewer(viewer);
	}

	public Viewer fetchViewerById(int viewerId) {
		return viewerDao.fetchViewerById(viewerId);
	}

	public Viewer  deleteViewerById(int viewerId) {
		return viewerDao.deleteViewerById(viewerId);
		
	}

	public Viewer  updateViewerById(int oldViewerId,Viewer  newViewer) {
		newViewer .setViewerId(oldViewerId);
		return viewerDao.saveViewer(newViewer);
	}

	public List<Viewer> fetchAllViewer() {
		return viewerDao.fetchAllViewer();
	}

	public Viewer addExistingTicketToExistingViewer(int ticketId, int viewerId) {
		return viewerDao.addExistingTicketToExistingViewer(ticketId, viewerId);
	}
	
	public Viewer addNewTicketToExistingViewer(Ticket newTicket, int viewerId) {
		return viewerDao.addNewTicketToExistingViewer(newTicket, viewerId);
	}
	
	public Viewer addExistingFoodToExistingViewer(int foodId, int viewerId) {
		return viewerDao.addExistingFoodToExistingViewer(foodId, viewerId);
	}
	
	public Viewer addNewFoodToExistingViewer(Food newFood, int viewerId) {
		return viewerDao.addNewFoodToExistingViewer(newFood, viewerId);
	}

}
