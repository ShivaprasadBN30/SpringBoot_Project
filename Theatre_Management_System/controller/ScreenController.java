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

import com.project.Theatre_Management_System.dto.Screen;
import com.project.Theatre_Management_System.dto.Seat;
import com.project.Theatre_Management_System.service.ScreenService;
@RestController
public class ScreenController {
	@Autowired
	ScreenService screenService;
	@PostMapping("/saveScreen")
	public Screen saveScreen(@RequestBody Screen screen) {
		return  screenService.saveScreen(screen);		
	}

	@GetMapping("/fetchScreenById")
	public  Screen fetchScreenById(@RequestParam int screenId) {
		return screenService.fetchScreenById(screenId);
	}

	@DeleteMapping("/deleteScreenById")
	public  Screen deleteScreenById(@RequestParam int screenId) {
		return screenService.deleteScreenById(screenId);
		
	}

	@PutMapping("/updateScreenById")
	public  Screen updateScreenById(@RequestParam int oldScreenId,@RequestBody Screen newScreen) {
		newScreen.setScreenId(oldScreenId);
		return screenService.saveScreen(newScreen);
	}

	@GetMapping("/fetchAllScreen")
	public List<Screen> fetchAllScreen() {
		return screenService.fetchAllScreen();
	}
	
	@PutMapping("/addExistingMovieToExistingScree")
	public Screen addExistingMovieToExistingScree(@RequestParam int screenId,@RequestParam int movieId) {
		 return screenService.addExistingMovieToExistingScree(screenId, movieId);
	}
	
	@PutMapping("/addExistingSeatToExistingScreen")
	public Screen addExistingSeatToExistingScreen(int screenId,int seatId) {
		return screenService.addExistingSeatToExistingScreen(screenId, seatId);
	}
	
	@PutMapping("/addNewSeatToExistingScreen")
	public Screen addNewSeatToExistingScreen(Seat newSeat,int screenId) {
		return screenService.addNewSeatToExistingScreen(newSeat, screenId);
	}
}
