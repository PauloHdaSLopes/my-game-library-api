package br.com.home.gameLibrary.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.home.gameLibrary.controller.dto.GameDto;
import br.com.home.gameLibrary.model.Game;
import br.com.home.gameLibrary.model.Usuario;
import br.com.home.gameLibrary.repository.GameRepository;
import br.com.home.gameLibrary.repository.UsuarioRepository;

@RestController
@RequestMapping("/user/{id}")
public class UsuarioController {

	@Autowired
	UsuarioRepository repo;
	
	@Autowired
	GameRepository gameRepo;
	
	@GetMapping("/games")
	public ResponseEntity<List<GameDto>> getAllFromUser( @PathVariable Long id) {
		 Optional<Usuario> userFromRepo = repo.findById(id);
		 
		 if(!userFromRepo.isPresent())
			 return ResponseEntity.notFound().build();
		 
		 List<Game> gamesFromUser = userFromRepo.get().getGames();
		 return ResponseEntity.ok(gamesFromUser.stream().map(GameDto::new).collect(Collectors.toList()));
	}
	
	@PostMapping("/games/{gameId}")
	@Transactional
	public ResponseEntity addGameToUser(@PathVariable Long id, @PathVariable Long gameId) {
		Optional<Usuario> userFromRepo = repo.findById(id);
		 
		 if(!userFromRepo.isPresent())
			 return ResponseEntity.notFound().build();
		 
		Optional<Game> gameFromRepo = gameRepo.findById(gameId);
		
		if(!gameFromRepo.isPresent())
			return ResponseEntity.notFound().build();
		
		Usuario user = userFromRepo.get();
		Game game = gameFromRepo.get();
		
		user.addGame(game);
		
		return ResponseEntity.ok().build();
	}
}
