package br.com.home.gameLibrary.controller.dto;

import java.time.LocalDate;

import br.com.home.gameLibrary.model.GameTime;

public class GameTimeDto {
	private String name;
	private Integer timeInHours;
	
	public GameTimeDto(GameTime gameTime) {
		this.name = gameTime.getName();
		this.timeInHours = gameTime.getTimeInHours();
	}

	public String getName() {
		return name;
	}

	public Integer getTimeInHours() {
		return timeInHours;
	}
	
}
