package hh.Harjotustyo.harjotustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long BookId;
	private String Author;
	private String Name;
	private int Year;
	private String Genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	
	public Book() {
		super();
	}
	public Book( String author,  String name, int year, String genre) {
		super();
		Author = author;
		Name = name;
		Year = year;
		Genre = genre;
	}
	public Long getBookId() {
		return BookId;
	}
	public void setBookId(Long bookId) {
		BookId = bookId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	
	
}
