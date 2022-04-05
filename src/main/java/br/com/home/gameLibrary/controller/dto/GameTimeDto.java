package br.com.home.gameLibrary.controller.dto;

import java.time.LocalDate;

import br.com.home.gameLibrary.model.GameTime;

public class GameTimeDto {
	private long id;
	private String name;
	private Integer timeInHours;
	private LocalDate creationDate;
	
	public GameTimeDto(GameTime gameTime) {
		this.id = gameTime.getId();
		this.name = gameTime.getName();
		this.timeInHours = gameTime.getTimeInHours();
		this.creationDate = gameTime.getCreationDate();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getTimeInHours() {
		return timeInHours;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}
	
}
