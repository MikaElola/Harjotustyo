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
	private Long MovieID;
	private String Title;
	private int Year;
	private String Genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Movie() {
		super();
	}
	public Movie(String title, int year, String genre) {
		super();
		Title = title;
		Year = year;
		Genre = genre;
	}
	public Long getMovieID() {
		return MovieID;
	}
	public void setMovieID(Long movieID) {
		MovieID = movieID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
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
