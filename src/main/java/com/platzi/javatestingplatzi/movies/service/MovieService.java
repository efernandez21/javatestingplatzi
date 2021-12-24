package com.platzi.javatestingplatzi.movies.service;

import com.platzi.javatestingplatzi.movies.data.MovieRepository;
import com.platzi.javatestingplatzi.movies.model.Genre;
import com.platzi.javatestingplatzi.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre comedy) {
        //Filtrando las películas usando programación Funcional
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre().equals(comedy)).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDuration(int duracion) {

        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= duracion).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByName(String evil) {
        return movieRepository.findAll().stream().filter(movie -> movie.getName().contains(evil)).collect(Collectors.toList());
    }
}
