package com.project.Theatre_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Theatre_Management_System.dto.Movie;
import com.project.Theatre_Management_System.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@PostMapping("/saveMovie")
	public Movie saveMovie(Movie movie) {
		return movieService.saveMovie(movie);
	}

	@GetMapping("/fetchMovieById")
	public Movie fetchMovieById(int movieId) {
		return movieService.fetchMovieById(movieId);
	}

	@DeleteMapping("/deleteMovieById")
	public Movie deleteMovieById(int movieId) {
		return movieService.deleteMovieById(movieId);
	}

	@PutMapping("/updateMovieById")
	public Movie updateMovieById(int oldMovieId, Movie newMovie) {
		newMovie.setMovieId(oldMovieId);
		return movieService.saveMovie(newMovie);
	}

	@GetMapping("/fetchAllMovie")
	public List<Movie> fetchAllMovie() {
		return movieService.fetchAllMovie();
	}
}
