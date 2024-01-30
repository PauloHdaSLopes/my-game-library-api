package br.com.home.gameLibrary;

import br.com.home.gameLibrary.model.Game;
import br.com.home.gameLibrary.model.GameTime;
import br.com.home.gameLibrary.repository.GameRepository;
import br.com.home.gameLibrary.repository.GameTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableSwagger2
public class GameLibraryApplication implements CommandLineRunner {

	@Autowired
	GameRepository gameRepo;
	@Autowired
	GameTimeRepository timeRepo;

	public static void main(String[] args) {
		SpringApplication.run(GameLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Game metroid = new Game(null, "Metroid Prime", "Super hyper master game", new String[]{"Action", "Platform", "Puzzle"}, 99);
		GameTime metroidMain = new GameTime("Main", 23);
		GameTime metroid100 = new GameTime("100%", 45);

		metroid.addGameTime(Arrays.asList(metroidMain, metroid100));
		metroidMain.setGame(metroid);
		metroid100.setGame(metroid);

		Game guildWars = new Game(null, "Guild Wars 2", "MMORPG", new String[] {"RPG", "MMO", "Multiplayer", "Online"}, 70);
		GameTime guildMain = new GameTime("Main", 40);
		GameTime guild100 = new GameTime("100%", 200);

		guildWars.addGameTime(Arrays.asList(guildMain, guild100));
		guildMain.setGame(guildWars);
		guild100.setGame(guildWars);

		gameRepo.saveAll(Arrays.asList(metroid, guildWars));
		timeRepo.saveAll(Arrays.asList(metroidMain, metroid100, guildMain, guild100));
	}
}
