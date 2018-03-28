package hh.Harjotustyo.harjotustyo;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.Harjotustyo.harjotustyo.domain.Book;
import hh.Harjotustyo.harjotustyo.domain.BookRepository;
import hh.Harjotustyo.harjotustyo.domain.Category;
import hh.Harjotustyo.harjotustyo.domain.CategoryRepository;
import hh.Harjotustyo.harjotustyo.domain.Movie;
import hh.Harjotustyo.harjotustyo.domain.MovieRepository;
import hh.Harjotustyo.harjotustyo.domain.Music;
import hh.Harjotustyo.harjotustyo.domain.MusicRepository;
import hh.Harjotustyo.harjotustyo.domain.User;
import hh.Harjotustyo.harjotustyo.domain.UserRepository;

@SpringBootApplication
public class HarjotustyoApplication {
	private static final Logger log = LoggerFactory.getLogger(HarjotustyoApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(HarjotustyoApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository brepo, CategoryRepository crepo, MovieRepository mrepo, UserRepository urepo, MusicRepository musicrepo){
		return (args) ->  {
			
	log.info("pari kirjaa");
	brepo.save(new Book("George Orwell", "1984", 1948, "Sci-fi"));
	brepo.save(new Book("Dr.Seuss","Cat in a Hat", 1950, "Childrens Literature"));
	
	log.info("kategoriat");
	crepo.save(new Category("Movie"));
	crepo.save(new Category("Music"));
	crepo.save(new Category("Book"));
	
	log.info("pari leffaa");
	mrepo.save(new Movie("The Matrix", 1998, "Sci-fi, Action"));
	mrepo.save(new Movie("Caddyshack", 1980, "Comedy"));
		
	log.info("pari musaa");
	musicrepo.save(new Music("Anderson.Paak", "Malibu", 2017, "Soul,RnB"));
	musicrepo.save(new Music("The Acacia Strain", "Coma Witch", 2016, "Deathmetal"));
	
	log.info("userit");
	 User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
	 User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepo.save(user1);
		urepo.save(user2);
		
	log.info("hae kaikki");
	for (Music music : musicrepo.findAll()){
		log.info(music.toString());
	}
		
		};
}
}
	
	
	
	
	

