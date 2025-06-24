package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Branch;
import com.project.Theatre_Management_System.dto.Movie;
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.repo.ScreenRepo;
@Repository
public class ScreenDao {
	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	SeatDao seatDao;
	public Screen saveScreen( Screen screen) {
		return  screenRepo.save(screen);		
	}

	public  Screen fetchScreenById(int screenId) {
		return screenRepo.findById(screenId).get();
	}

	public  Screen deleteScreenById(int screenId) {
		 Screen screen= screenRepo.findById(screenId).get();
		screenRepo.delete(screen);
		return screen;
	}

	public  Screen updateScreenById(int oldScreenId, Screen newScreen) {
		newScreen.setScreenId(oldScreenId);
		return screenRepo.save(newScreen);
	}

	public List< Screen> fetchAllScreen() {
		return screenRepo.findAll();
	}
	public Screen addExistingMovieToExistingScree(int screenId,int movieId) {
		Screen screen=fetchScreenById(screenId);
		Movie movie=movieDao.fetchMovieById(movieId);
		screen.setMovie(movie);
		return saveScreen(screen);
	}
	
	public Screen addExistingSeatToExistingScreen(int screenId,int seatId) {
		
		Screen screen=fetchScreenById(screenId);
		Seat seat=seatDao.fetchSeatById(seatId);
		List<Seat>list=screen.getSeat();
		list.add(seat);
		screen.setSeat(list);
		return saveScreen(screen);
	}
	
	public Screen addNewSeatToExistingScreen(Seat newSeat,int screenId) {
		Screen screen=fetchScreenById(screenId);
		List<Seat>list=screen.getSeat();
		list.add(newSeat);
		screen.setSeat(list);
		return saveScreen(screen);
		
	}

}
