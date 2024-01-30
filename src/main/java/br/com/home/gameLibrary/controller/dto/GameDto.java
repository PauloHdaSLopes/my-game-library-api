package br.com.home.gameLibrary.controller.dto;

import java.time.LocalDate;
import java.util.Set;

import br.com.home.gameLibrary.model.Game;
import br.com.home.gameLibrary.model.GameTime;

public class GameDto {
	private Long id;
	private String name;
	private String description;
	private String[] genre;
	private Integer ratingPercent;
	private Set<GameTime> gametime;
	private LocalDate creationDate = LocalDate.now();
	
	public GameDto(Game game) {
		this.id = game.getId();
		this.name = game.getName();
		this.description = game.getDescription();
		this.genre = game.getGenre();
		this.ratingPercent = game.getRatingPercent();
		this.creationDate = game.getCreationDate();
		this.gametime = game.getGameTimes();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String[] getGenre() {
		return genre;
	}

	public Integer getRatingPercent() {
		return ratingPercent;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public Set<GameTime> getGametime() {
		return gametime;
	}
}
