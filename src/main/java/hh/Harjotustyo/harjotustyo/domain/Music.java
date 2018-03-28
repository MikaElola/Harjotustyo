package hh.Harjotustyo.harjotustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Music {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long musicID;
	private String artist;
	private String name;
	private int year;
	private String genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Music() {
		super();
	}
	public Music(String artist, String name, int year, String genre) {
		super();
		this.artist = artist;
		this.name = name;
		this.year = year;
		this.genre = genre;
	}
	public Long getMusicID() {
		return musicID;
	}
	public void setMusicID(Long musicID) {
		this.musicID = musicID;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
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
