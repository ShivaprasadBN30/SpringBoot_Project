package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.dto.Viewer;
import com.project.Theatre_Management_System.repo.SeatRepo;
@Repository
public class SeatDao {
	@Autowired
	SeatRepo seatRepo;
	
	@Autowired
	ViewerDao viewerDao;
	public Seat saveSeat( Seat seat) {
		return  seatRepo.save(seat);		
	}

	public  Seat fetchSeatById(int seatId) {
		return seatRepo.findById(seatId).get();
	}

	public  Seat deleteSeatById(int seatId) {
		Seat seat= seatRepo.findById(seatId).get();
		seatRepo.delete(seat);
		return seat;
	}

	public  Seat updatSeatById(int oldSeatId, Seat newSeat) {
		newSeat.setSeatId(oldSeatId);
		return seatRepo.save(newSeat);
	}

	public List<Seat> fetchAllSeat() {
		return seatRepo.findAll();
	}
	public Seat addExistingViewerToExistingSeat(int seatId,int viewerId) {
		Seat seat=fetchSeatById(seatId);
		Viewer viewer=viewerDao.fetchViewerById(viewerId);
		seat.setViewer(viewer);
		return saveSeat(seat);
	}
}
