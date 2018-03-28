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
	public Long bookID;
	private String author;
	private String name;
	private int year;
	private String genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	
	public Book() {
		super();
	}
	public Book( String author,  String name, int year, String genre) {
		super();
		this.author = author;
		this.name = name;
		this.year = year;
		this.genre = genre;
	}
	public Long getbookID() {
		return bookID;
	}
	public void setbookID(Long bookID) {
		this.bookID = bookID;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
