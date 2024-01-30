package br.com.home.gameLibrary.controller.form;

import java.util.List;

import br.com.home.gameLibrary.model.Game;

public class GameForm {

	private String name;
	private String description;
	private String genre;
	private String ratingPercent;
	private List<GameTimeForm> gameTimes;

	public GameForm() {
		
	}
	
	public GameForm(String name, String description, String genre, String ratingPercent,
			List<GameTimeForm> gameTimesForm) {
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.ratingPercent = ratingPercent;
		this.gameTimes = gameTimesForm;
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
	public String getGenre() {
		return genre;
	}
	private String[] getArrayGenre() {
		return this.genre.split(",");
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRatingPercent() {
		return ratingPercent;
	}
	private Integer getIntRatingPercent() {
		return Integer.valueOf(this.ratingPercent);
	}
	public void setRatingPercent(String ratingPercent) {
		this.ratingPercent = ratingPercent;
	}
	public List<GameTimeForm> getGameTimesForm() {
		return gameTimes;
	}
	public void setGameTimes(List<GameTimeForm> gameTimes) {
		this.gameTimes = gameTimes;
	}
	
	public Game toGame() {
		Game g = new Game();
		g.setName(this.name);
		g.setDescription(this.description);
		g.setGenre(this.getArrayGenre());
		g.setRatingPercent(this.getIntRatingPercent());
		this.gameTimes.forEach(t -> g.addGameTime(t.toGameTime(g)));
		return g;
	}

	@Override
	public String toString() {
		return "GameForm [name=" + name + ", description=" + description + ", genre=" + genre + ", ratingPercent="
				+ ratingPercent + ", gameTimes=" + gameTimes + "]";
	}

}
