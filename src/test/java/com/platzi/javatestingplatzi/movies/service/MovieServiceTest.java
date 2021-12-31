package com.platzi.javatestingplatzi.movies.service;



//import static org.junit.Assert.*;

import com.platzi.javatestingplatzi.movies.data.MovieRepository;
import com.platzi.javatestingplatzi.movies.model.Genre;
import com.platzi.javatestingplatzi.movies.model.Movie;
import static org.hamcrest.MatcherAssert.*;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
//import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceTest {
    /*
        Se puede hacer el uso de @RunWith(MockitoJUnitRunner.class) y  de @Mock y @InjectMocks
     */
    private MovieService movieService;
    @Before
    public void setUp() {
        //Generamos un Mock de mi repository para la prueba de carga de peliculas
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        //Simulación de los posibles resultados a obtener al ejecutar ese metodo
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void movies_by_genre() {


        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        /*
            Forma general resuelta por el instructor, con el manejo de otra lista con el control de los ids
         */
        //List<Integer> movieIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        //assertThat(movieIds, CoreMatchers.is(Arrays.asList(3,6)));
        // Forma con el everyItem para comprobar una propiedad específica
        assertThat(movies, CoreMatchers.everyItem(Matchers.hasProperty("genre",CoreMatchers.is(Genre.COMEDY))));
    }
    @Test
    public void return_movie_by_name_or_keyword()
    {
        Collection<Movie> movies = movieService.findMovieByName("ome");
        List<String> movieName = movies.stream().map(Movie::getName).collect(Collectors.toList());

        assertThat(movieName, CoreMatchers.is(Arrays.asList("There's Something About Mary", "Home Alone")));
    }
    @Test
    public void movies_by_duration() {
        Collection<Movie> movies = movieService.findMoviesByDuration(120);
        List<Integer> movieIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(2,3,4,5,6)));
        //assertTrue(movies.stream().allMatch(movie -> movie.getMinutes() <= 119));
    }
    //Test a futuro para una negativa en la duracion
    @Test(expected = IllegalArgumentException.class)
    public void return_movies_by_negative_length(){
        Collection<Movie> movies = movieService.findMoviesByDuration(-1);
    }
    //Metodo para devolver los ids de una película ya filtrada
     private List<Integer> getMovieIds(Collection<Movie> movies) {
        List<Integer> getId = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        return getId;
     }
    //Test creados para el reto de busqueda por plantilla

    @Test
    public void return_movies_with_template_and_by_properties_duration_and_genre() {
        assertThat(
            getMovieIds(movieService.findMoviesByTemplatePrueba(
                    new Movie(null, 150, Genre.ACTION))),
                CoreMatchers.is(Arrays.asList(7)));

    }

    @Test
    public void return_movies_with_template_and_by_properties_name_and_duration() {
        assertThat(
                getMovieIds(movieService.findMoviesByTemplatePrueba(
                        new Movie("ome", 105, null))),
                CoreMatchers.is(Arrays.asList(6)));
    }

    @Test
    public void  return_movies_with_template_and_by_properties_name_and_genre() {
        assertThat(
                getMovieIds(movieService.findMoviesByTemplatePrueba(
                        new Movie("ome", null,  Genre.COMEDY))),
                CoreMatchers.is(Arrays.asList(3,6)));
    }
    @Test
    public void  return_movies_with_template_and_by_properties_name_duration_and_genre() {
        assertThat(
                getMovieIds(movieService.findMoviesByTemplatePrueba(
                        new Movie("me", 150,  Genre.THRILLER))),
                CoreMatchers.is(Arrays.asList(2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void return_IllegalArgumentException_because_all_properties_are_null() {
        Collection<Movie> movies = movieService.findMoviesByTemplatePrueba(
                new Movie(null, null,  null));
    }
}