package br.com.home.gameLibrary.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game_time")
public class GameTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private Integer timeInHours;
	private LocalDate creationDate = LocalDate.now();
	@ManyToOne
    @JoinColumn(name="game_id", nullable=false)
    private Game game;
	
	public GameTime() {
		
	}
	
	public GameTime(String name, Integer timeInHours, Game game) {
		this.name = name;
		this.timeInHours = timeInHours;
		this.game = game;
	}
	
	public long getId() {
		return id;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTimeInHours() {
		return timeInHours;
	}
	public void setTimeInHours(Integer timeInHours) {
		this.timeInHours = timeInHours;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}
