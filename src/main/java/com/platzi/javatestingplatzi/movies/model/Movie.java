package com.platzi.javatestingplatzi.movies.model;

public class Movie {

    private Integer id;
    private String name;
    private int minutes;
    private Genre genre;

    /*
        Constructor para cuando no se tiene el identificador especificado
     */
    public Movie(String name, int minutes, Genre genre) {
        this(null, name, minutes, genre);
    }
    /*
        Constructor parametrizado con todos los parámetros de la clase disponibles
     */
    public Movie(Integer id, String name, int minutes, Genre genre) {
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

    public int getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }
}
