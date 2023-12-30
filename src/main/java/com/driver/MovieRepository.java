package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class MovieRepository {
    HashMap<String, Movie> movieList;
    HashMap<String, Director> directorList;
    HashMap<String, List<Movie>> directorMovieMap;
    public MovieRepository(){
        this.movieList = new HashMap<>();
        this.directorList = new HashMap<>();
        this.directorMovieMap = new HashMap<>();
    }
    public void addMovie(Movie movie){
        movieList.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
        directorList.put(director.getName(), director);
    }
    public void addMovieDirectorPair(String movie, String director){
        if(!directorMovieMap.containsKey(director)){
            directorMovieMap.put(director, new ArrayList<>());
        }
        directorMovieMap.get(director).add(getMovieByName(movie));
    }
    public Movie getMovieByName(String name){
        return movieList.get(name);
    }
    public Director getDirectorByName(String name){
        return directorList.get(name);
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> allMovieByDirectorName = new ArrayList<>();
        for(Movie movie : directorMovieMap.get(director)){
            allMovieByDirectorName.add(movie.getName());
        }
        return allMovieByDirectorName;
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movieList.keySet());
    }
    public void deleteDirectorByName(String director_name){
        for(Movie movie : directorMovieMap.get(director_name)){
            movieList.remove(movie.getName());
        }
        directorList.remove(director_name);
        directorMovieMap.remove(director_name);
    }
    public void deleteAllDirectors(){
       for(String directorName : directorList.keySet()){
           for(Movie movie : directorMovieMap.get(directorName)){
               movieList.remove(movie.getName());
           }
           directorMovieMap.remove(directorName);
       }
       directorList.clear();
    }
}
