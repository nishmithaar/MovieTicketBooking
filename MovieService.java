package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements MovieServiceInterface {
    private final Map<String, Movie> movieRepository = new HashMap<>();

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieRepository.values());
    }

    @Override
    public void addMovie(Movie movie) {
        if (movieRepository.containsKey(movie.getId())) {
            throw new IdAlreadyExist("Movie with id " + movie.getId() + " already exists");
        }
        movieRepository.put(movie.getId(), movie);
    }

    @Override
    public Movie getMovieById(String id) {
        Movie movie = movieRepository.get(id);
        if (movie == null) {
            throw new IdNotFound("Movie with id " + id + " not found");
        }
        return movie;
    }

    @Override
    public void deleteMovieById(String id) {
        if (!movieRepository.containsKey(id)) {
            throw new IdNotFound("Movie with id " + id + " not found");
        }
        movieRepository.remove(id);
    }

    @Override
    public void updateMovieById(String id, Movie movie) {
        if (!movieRepository.containsKey(id)) {
            throw new IdNotFound("Movie with id " + id + " not found");
        }
        movieRepository.put(id, movie);
    }
}
