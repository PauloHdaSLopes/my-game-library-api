package br.com.home.gameLibrary.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Lob
	@Column(length = 501)
	private String description;
	private String[] genre;
	private Integer ratingPercent;
	private LocalDate creationDate = LocalDate.now();
	
	@OneToMany(mappedBy="game")
	Set<GameTime> gameTimes = new HashSet<>();

	public Game() {
	}

	public Game(Long id, String name, String description, String[] genre, Integer ratingPercent) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.ratingPercent = ratingPercent;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getGenre() {
		return genre;
	}
	public void setGenre(String[] genre) {
		this.genre = genre;
	}
	public Integer getRatingPercent() {
		return ratingPercent;
	}
	public void setRatingPercent(Integer ratingPercent) {
		this.ratingPercent = ratingPercent;
	}
	public Set<GameTime> getGameTimes() {
		return gameTimes;
	}
	private String getGameTimesToString() {
		String aux = "[";
		
		for(GameTime g : this.gameTimes) {
			aux+= g.getName() + ": " + g.getTimeInHours() + ", ";
		}
		
		aux += "]";
		
		aux = aux.replace(", ]", "]");
		
		return aux;
	}
	
	private String getGenreToString() {
		String aux = "[";
		
		for(String s : this.genre) {
			aux+= s + ", ";
		}
		
		aux += "]";
		
		aux = aux.replace(", ]", "]");
		
		return aux;
	}
	public void addGameTime(List<GameTime> g) {
		g.forEach(this::addGameTime);
	}
	public void addGameTime(GameTime gameTime) {
		this.gameTimes.add(gameTime);
	}
	@Override
	public String toString() {
		return "Game{name: " + this.name + 
				", description: " + this.description + 
				", genre: " + getGenreToString() +
				", rating: " + this.ratingPercent + 
				", game times: " + getGameTimesToString() +
				", creation date: " + this.creationDate + "}";
	}
}
