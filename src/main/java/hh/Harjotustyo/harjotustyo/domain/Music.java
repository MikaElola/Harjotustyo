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
	private String Artist;
	private String Name;
	private int Year;
	private String Genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Music() {
		super();
	}
	public Music(String artist, String name, int year, String genre) {
		super();
		Artist = artist;
		Name = name;
		Year = year;
		Genre = genre;
	}
	public Long getMusicID() {
		return musicID;
	}
	public void setMusicID(Long musicID) {
		this.musicID = musicID;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) {
		Artist = artist;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
