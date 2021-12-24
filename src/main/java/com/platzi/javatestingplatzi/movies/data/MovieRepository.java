package com.platzi.javatestingplatzi.movies.data;

import com.platzi.javatestingplatzi.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(Long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
