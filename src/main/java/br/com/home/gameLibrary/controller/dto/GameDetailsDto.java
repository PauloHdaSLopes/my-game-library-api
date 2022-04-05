package br.com.home.gameLibrary.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.home.gameLibrary.model.Game;

public class GameDetailsDto {

	private Long id;
	private String name;
	private String description;
	private String[] genre;
	private Integer ratingPercent;
	private LocalDate creationDate = LocalDate.now();
	private List<GameTimeDto> gameTimes;
	
	public GameDetailsDto(Game game) {
		this.id = game.getId();
		this.name = game.getName();
		this.description = game.getDescription();
		this.genre = game.getGenre();
		this.ratingPercent = game.getRatingPercent();
		this.creationDate = game.getCreationDate();
		this.gameTimes = game.getGameTimes().stream().map(GameTimeDto::new).collect(Collectors.toList());
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

	public List<GameTimeDto> getGameTimes() {
		return gameTimes;
	}
	
}
