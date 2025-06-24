package com.project.Theatre_Management_System.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Movie;
import com.project.Theatre_Management_System.repo.MovieRepo;

@Repository
public class MovieDao {
	@Autowired
	MovieRepo movieRepo;

	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	public Movie fetchMovieById(int movieId) {
		return movieRepo.findById(movieId).get();
	}

	public Movie deleteMovieById(int movieId) {
		Movie movie = movieRepo.findById(movieId).get();
		movieRepo.delete(movie);
		return movie;
	}

	public Movie updateMovieById(int oldMovieId, Movie newMovie) {
		newMovie.setMovieId(oldMovieId);
		return movieRepo.save(newMovie);
	}

	public List<Movie> fetchAllMovie() {
		return movieRepo.findAll();
	}
}
