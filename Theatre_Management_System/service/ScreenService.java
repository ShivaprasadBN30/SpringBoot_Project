package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.ScreenDao;
import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Seat;

@Service
public class ScreenService {
	@Autowired
	ScreenDao screenDao;
	public Screen saveScreen( Screen screen) {
		return  screenDao.saveScreen(screen);		
	}

	public  Screen fetchScreenById(int screenId) {
		return screenDao.fetchScreenById(screenId);
	}

	public  Screen deleteScreenById(int screenId) {
		return screenDao.deleteScreenById(screenId);
		
	}

	public  Screen updateScreenById(int oldScreenId, Screen newScreen) {
		newScreen.setScreenId(oldScreenId);
		return screenDao.saveScreen(newScreen);
	}

	public List< Screen> fetchAllScreen() {
		return screenDao.fetchAllScreen();
	}
	public Screen addExistingMovieToExistingScree(int screenId,int movieId) {
		 return screenDao.addExistingMovieToExistingScree(screenId, movieId);
	}
	
	public Screen addExistingSeatToExistingScreen(int screenId,int seatId) {
		return screenDao.addExistingSeatToExistingScreen(screenId, seatId);
	}
	public Screen addNewSeatToExistingScreen(Seat newSeat,int screenId) {
		return screenDao.addNewSeatToExistingScreen(newSeat, screenId);
	}
}
