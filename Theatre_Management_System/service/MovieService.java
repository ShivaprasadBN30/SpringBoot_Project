package com.project.Theatre_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.MovieDao;
import com.project.Theatre_Management_System.dto.Movie;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;
	public Movie saveMovie(Movie movie) {
		return movieDao.saveMovie(movie);
	}

	public Movie fetchMovieById(int movieId) {
		return movieDao.fetchMovieById(movieId);
	}

	public Movie deleteMovieById(int movieId) {
		return movieDao.deleteMovieById(movieId);
		
	}

	public Movie updateMovieById(int oldMovieId, Movie newMovie) {
		newMovie.setMovieId(oldMovieId);
		return movieDao.saveMovie(newMovie);
	}

	public List<Movie> fetchAllMovie() {
		return movieDao.fetchAllMovie();
	}
}
