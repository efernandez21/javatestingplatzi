package com.platzi.javatestingplatzi.movies.data;

import com.platzi.javatestingplatzi.movies.model.Genre;
import com.platzi.javatestingplatzi.movies.model.Movie;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;


public class MovieRepositoryIntegrationTest {

    private static JdbcTemplate jdbcTemplate;
    private MovieRepositoryJdbc movieRepository;

    @BeforeClass
    public static void beforeClass() throws Exception {
        //Definicion de la conexion a la base de datos
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        //Ejecucion del script inicial en memoria, con el recurso donde se encuentra, en este caso en la carpeta resources
        ScriptUtils.executeSqlScript(dataSource.getConnection(),new ClassPathResource("sql-scripts/test-data.sql"));
        //Recibe la conexion a la base de datos
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void setUp() throws Exception {
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {

        //Carga de todas las peliculas
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies,is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION) ,
                new Movie(2, "Memento", 113, Genre.THRILLER) ,
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }
}