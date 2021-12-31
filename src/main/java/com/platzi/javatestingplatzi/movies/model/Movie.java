package com.platzi.javatestingplatzi.movies.model;

import java.util.Objects;

public class Movie {

    private Integer id;
    private String name;
    private Integer minutes;
    private Genre genre;

    /*
        Constructor para cuando no se tiene el identificador especificado
     */
    public Movie(String name, Integer minutes, Genre genre) {
        this(null, name, minutes, genre);
    }
    /*
        Constructor parametrizado con todos los parámetros de la clase disponibles
     */
    public Movie(Integer id, String name, Integer minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    /**
     * Metodos Java sobreescritos para la comparacion de peliculas en este caso por los problemas de comparativa de objetos
     * @param o el objeto a comparar
     * @return true o false dependiendo de la similitud del objeto
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre);
    }
}
