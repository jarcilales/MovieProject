package com.test.movietest.Services;

import com.test.movietest.Model.Movie;
import com.test.movietest.Repository.IMovieRepository;
import com.test.movietest.Util.CustomErrorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository iMovieRepository;
    
    public MovieService(IMovieRepository iMovieRepository) {
		super();
		this.iMovieRepository = iMovieRepository;
	}

	public ResponseEntity<List<Movie>> getAllMovies() {
    	List<Movie> movies = iMovieRepository.findAll();
    	
        if (movies.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    public ResponseEntity<Movie> getMoviesById(Long id) {
    	Movie movie = iMovieRepository.getOne(id);

    	if (movie == null)
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    	return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    
    public ResponseEntity<Movie> addMovie(Movie movie) {
    	iMovieRepository.save(movie);
    	
    	return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
    
    public void saveMovies(List<Movie> movies) {
    	iMovieRepository.saveAll(movies);
    }
    	
    
}
