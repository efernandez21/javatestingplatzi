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
        if (duracion <0) throw new IllegalArgumentException("Duracion especificada Invalida");
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= duracion).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByName(String evil) {
        return movieRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(evil)).collect(Collectors.toList());
    }

    /**
     * Metodo del Reto para buscar una pelicula dado ciertos atributos
     * @param template
     * @return una lista de peliculas que cumplen las condiciones de template
     */
    public Collection<Movie> findMoviesByTemplate(Movie template) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().equalsIgnoreCase(template.getName())  ||
                        (movie.getMinutes() <= template.getMinutes()) &&
                        movie.getGenre().equals(template.getGenre())).collect(Collectors.toList());
    }
    /**
     * Metodo del Reto para buscar una pelicula dado ciertos atributos
     * @param template pelicula modelo a buscar
     * @return una lista de peliculas que cumplen las condiciones de template
     */
    public Collection<Movie> findMoviesByTemplatePrueba(Movie template) {
        if (template.getName() != null){
            //Filtramos por nombre
            if (template.getMinutes() != null){
                //Filtramos por nombre y minutos
                if (template.getGenre() != null){
                    //Filtramos por nombre, duración y genero
                    return movieRepository.findAll().stream()
                            .filter(movie -> movie.getName().contains(template.getName()) &&
                                            (movie.getMinutes() <= template.getMinutes()) &&
                                    movie.getGenre().equals(template.getGenre())
                            ).collect(Collectors.toList());
                } else {
                    //Filtramos por nombre y duración
                    return movieRepository.findAll().stream()
                            .filter(movie -> movie.getName().contains(template.getName()) &&
                                    (movie.getMinutes() <= template.getMinutes())
                            ).collect(Collectors.toList());
                }
            } else {
                //Filtramos por nombre
                return findMovieByName(template.getName());
            }
        } else {
            if (template.getMinutes() != null){
                if (template.getGenre() != null){
                    //Filtramos por duracion y genero
                    return movieRepository.findAll().stream()
                            .filter(movie ->(movie.getMinutes() <= template.getMinutes()) &&
                                    movie.getGenre().equals(template.getGenre())
                            ).collect(Collectors.toList());
                }
                else {
                    //Filtramos por duración
                    return findMoviesByDuration(template.getMinutes());
                }
            } else{
                if (template.getGenre() != null){
                    //Filtramos por Genero
                    return findMoviesByGenre(template.getGenre());
                }
                else{
                    throw new IllegalArgumentException("Todos los parametros del template son nulos");
                }
            }
        }
    }
}
