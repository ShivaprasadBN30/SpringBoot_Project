package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Food;
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.dto.Theatre;
import com.project.Theatre_Management_System.dto.Ticket;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.repo.ViewerRepo;

@Repository
public class ViewerDao {
	@Autowired
	ViewerRepo viewerRepo;

	@Autowired
	TicketDao ticketDao;

	@Autowired
	FoodDao foodDao;
	public Viewer saveViewer(Viewer viewer) {
		return viewerRepo.save(viewer);
	}

	public Viewer fetchViewerById(int viewerId) {
		return viewerRepo.findById(viewerId).get();
	}

	public Viewer deleteViewerById(int viewerId) {
		Viewer viewer = viewerRepo.findById(viewerId).get();
		viewerRepo.delete(viewer);
		return viewer;
	}

	public Viewer updateViewerById(int oldViewerId, Viewer newViewer) {
		newViewer.setViewerId(oldViewerId);
		return viewerRepo.save(newViewer);
	}

	public List<Viewer> fetchAllViewer() {
		return viewerRepo.findAll();
	}

	public Viewer addExistingTicketToExistingViewer(int ticketId, int viewerId) {
		Viewer viewer = fetchViewerById(viewerId);
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		List<Ticket> list = viewer.getTicket();
		list.add(ticket);
		viewer.setTicket(list);
		return saveViewer(viewer);
	}

	public Viewer addNewTicketToExistingViewer(Ticket newTicket, int viewerId) {
		Viewer viewer = fetchViewerById(viewerId);
		List<Ticket> list = viewer.getTicket();
		list.add(newTicket);
		viewer.setTicket(list);
		return saveViewer(viewer);

	}
	
	public Viewer addExistingFoodToExistingViewer(int foodId, int viewerId) {
		Viewer viewer = fetchViewerById(viewerId);
		Food food= foodDao.fetchFoodById(foodId);
		List<Food> list = viewer.getFood();
		list.add(food);
		viewer.setFood(list);
		return saveViewer(viewer);
	}

	public Viewer addNewFoodToExistingViewer(Food newFood, int viewerId) {
		Viewer viewer = fetchViewerById(viewerId);
		List<Food> list = viewer.getFood();
		list.add(newFood);
		viewer.setFood(list);
		return saveViewer(viewer);

	}
}
