package com.example.MovieTicket.MovieBooking.controller;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieServiceInterface;
import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticket")
public class controller {

	@Autowired
    private MovieServiceInterface movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/movie")
    public ResponseEntity<String> addMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            String errors = bindingResult.getAllErrors().stream()
//                                         .map(e -> e.getDefaultMessage())
//                                         .collect(Collectors.joining(", "));
//            return ResponseEntity.badRequest().body("Validation errors occurred: " + errors);
//        }
        if(bindingResult.hasErrors()) {
            throw new RuntimeException("Request Not Valid");
        }
        movieService.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully");
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
        //return movieService.getMovieById(id);
    	Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable String id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMovieById(@Valid @RequestBody Movie movie, BindingResult bindingResult, @PathVariable String id) {
//        if (bindingResult.hasErrors()) {
//            String errors = bindingResult.getAllErrors().stream()
//                                         .map(e -> e.getDefaultMessage())
//                                         .collect(Collectors.joining(", "));
//            return ResponseEntity.badRequest().body("Validation errors occurred: " + errors);
//        }
        movieService.updateMovieById(id, movie);
        return ResponseEntity.ok("Movie updated successfully");
    }
}