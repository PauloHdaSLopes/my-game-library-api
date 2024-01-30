package br.com.home.gameLibrary.controller.form;

import br.com.home.gameLibrary.model.Game;
import br.com.home.gameLibrary.model.GameTime;

public class GameTimeForm {
	private String name;
	private String timeInHours;
	
	public GameTimeForm() {
	}
	
	public GameTimeForm(String name, String timeInHours) {
		this.name = name;
		this.timeInHours = timeInHours;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimeInHours() {
		return timeInHours;
	}
	public void setTimeInHours(String timeInHours) {
		this.timeInHours = timeInHours;
	}
	
	public GameTime toGameTime(Game game) {
		Integer time = Integer.valueOf(this.timeInHours);
		GameTime gameTime = new GameTime(this.name, time);
		gameTime.setGame(game);
		return gameTime;
	}

	@Override
	public String toString() {
		return "GameTimeForm [name=" + name + ", timeInHours=" + timeInHours + "]";
	}
	
}
