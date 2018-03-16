package hh.Harjotustyo.harjotustyo.domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long catID;
	private String kategoria;
	
	
	@OneToMany
	@JsonIgnore
	private List<Music> musics;
	
	@OneToMany
	@JsonIgnore
	private List<Book> books;
	
	@OneToMany
	@JsonIgnore
	private List<Movie> movies;
	
	
	public Category() {
		super();
	}
	public Category(String kategoria) {
		super();
		this.kategoria = kategoria;
	}
	
	public List<Music> getMusics() {
		return musics;
	}
	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public Long getCatID() {
		return catID;
	}
	public void setCatID(Long catID) {
		this.catID = catID;
	}
	public String getKategoria() {
		return kategoria;
	}
	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	
	
}
