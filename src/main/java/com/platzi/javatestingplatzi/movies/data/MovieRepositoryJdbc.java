package com.platzi.javatestingplatzi.movies.data;

import com.platzi.javatestingplatzi.movies.model.Genre;
import com.platzi.javatestingplatzi.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Clase que implementa la interface Repository y realiza el manejo en la base de datos
 */
public class MovieRepositoryJdbc implements MovieRepository {

    //Instancia ded JDBCTemplate para la interaccion con la base de datos por medio de querys SQL
    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(Long id) {
        //argumentos para el jdbc template como objetos
        Object[] args = { id };
        return jdbcTemplate.queryForObject("select * from movies where id = ?",args,movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        //En la consulta indico que quiero transformar cada fila obtenida en un objeto movie, usando el resultSet y buscando la respectiva columna
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        //actualizacion en la base de datos
        jdbcTemplate.
                update("insert into movies(name ,minutes,genre ) values( ?, ?, ?)",
                    movie.getName(),
                    movie.getMinutes(),
                    movie.getGenre().toString()
                );

    }
    //Mapeo de los resultados a un objeto Movie
    private static  RowMapper<Movie> movieMapper = (resultSet, i) ->
            new Movie(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("minutes"),
                Genre.valueOf(resultSet.getString("genre")));
}
