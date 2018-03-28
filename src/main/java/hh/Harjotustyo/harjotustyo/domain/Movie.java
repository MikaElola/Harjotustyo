package hh.Harjotustyo.harjotustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long movieID;
	private String title;
	private int year;
	private String genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Movie() {
		super();
	}
	public Movie(String title, int year, String genre) {
		super();
		this.title = title;
		this.year = year;
		this.genre = genre;
	}
	public Long getMovieID() {
		return movieID;
	}
	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
