package hh.Harjotustyo.harjotustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.Harjotustyo.harjotustyo.domain.Book;
import hh.Harjotustyo.harjotustyo.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepoTest {
	@Autowired
	private BookRepository brepo;
	
	@Test
	public void findByName(){
		List<Book> books = brepo.findByName("1984");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
	}
	@Test
	public void createNew(){
		Book book = new Book("Test", "Test", 2017, "Horror/Test");
		brepo.save(book);
		assertThat(book.getbookID()).isNotNull();
	}
	@Test
	public void delete(){
		List<Book> books = brepo.findByName("1984");
		Book book = books.get(0);
		brepo.delete(book);
		List<Book> books2 = brepo.findByName("1984");
		assertThat(books2).isEmpty();
	}
	
}
