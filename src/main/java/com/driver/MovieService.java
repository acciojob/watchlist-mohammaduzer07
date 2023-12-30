package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository MR;

    public void addMovie(Movie movie){
        MR.addMovie(movie);
    }
    public void addDirector(Director director){
        MR.addDirector(director);
    }
    public void addMovieDirectorPair(String movie, String director) {
        MR.addMovieDirectorPair(movie, director);
    }
    public Movie getMovieByName(String name){
        return MR.getMovieByName(name);
    }
    public Director getDirectorByName(String name){
        return MR.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String director){
        return MR.getMoviesByDirectorName(director);
    }
    public List<String> findAllMovies(){
        return MR.findAllMovies();
    }
    public void deleteDirectorByName(String director_name){
        MR.deleteDirectorByName(director_name);
    }
    public void deleteAllDirectors(){
        MR.deleteAllDirectors();
    }
}
