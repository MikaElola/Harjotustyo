package hh.Harjotustyo.harjotustyo;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.Harjotustyo.harjotustyo.domain.Movie;
import hh.Harjotustyo.harjotustyo.domain.MovieRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepoTest {
	 @Autowired
	 private MovieRepository mrepo;
	 
	 @Test
	 public void findbyName(){
		 List<Movie> movies = mrepo.findByTitle("The Matrix");
		 assertThat(movies).hasSize(1);
		 assertThat(movies.get(0).getYear()).isEqualTo(1998);
	 }
	 @Test
	 public void createNew(){
		 Movie movie = new Movie("Test", 2018, "Test");
		 mrepo.save(movie);
		 List<Movie> movies = mrepo.findByTitle("Test");
		 assertThat(movies).hasSize(1);
	 }
	 @Test
	 public void delete(){
		 List<Movie> movies = mrepo.findByTitle("The Matrix");
		 Movie movie = movies.get(0);
		 mrepo.delete(movie);
		 List<Movie> movies2 = mrepo.findByTitle("The Matrix");
		 assertThat(movies2).hasSize(0);
	 }
	 
	 
	 
}
