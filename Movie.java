package com.example.MovieTicket.MovieBooking.Model;

import jakarta.validation.constraints.*;
import java.util.List;

public class Movie {
    @NotNull
    @Min(1)
    private String id;
    @Size(min = 3, max = 20)
    private String movieName;

    @NotBlank
    @NotNull
    private String movieDirector;

    @Min(1)
    @Max(10)
    private long movieRating;

    private String movieLanguage;
    private List<String> writers;
    private List<String> actors;
    private List<String> genre;

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public long getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(long movieRating) {
		this.movieRating = movieRating;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public List<String> getWriters() {
		return writers;
	}
	public void setWriters(List<String> writers) {
		this.writers = writers;
	}
	public List<String> getActors() {
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
}
