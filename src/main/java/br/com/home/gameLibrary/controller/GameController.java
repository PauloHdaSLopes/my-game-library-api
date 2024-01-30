package br.com.home.gameLibrary.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import br.com.home.gameLibrary.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.home.gameLibrary.controller.dto.GameDetailsDto;
import br.com.home.gameLibrary.controller.dto.GameDto;
import br.com.home.gameLibrary.controller.form.GameForm;
import br.com.home.gameLibrary.model.Game;
import br.com.home.gameLibrary.repository.GameRepository;
import br.com.home.gameLibrary.repository.GameTimeRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameService gameService;

//	@GetMapping
//	public Page<GameDto> getAll(@PageableDefault(sort = "name", direction = Direction.ASC, page = 0, size = 10) Pageable paginator) {
//		Page<Game> gamesFromRepo = gameRepository.findAll(paginator);
//
//		return gamesFromRepo.map(GameDto::new);
//	}

	@GetMapping
	public List<GameDto> getAll() {
		List<Game> gamesFromRepo = gameService.getAll();
		return gamesFromRepo.stream().map(GameDto::new).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<GameDetailsDto> getById(@PathVariable Long id) {
		Optional<Game> opt = gameService.findById(id);
		if(!opt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new GameDetailsDto(opt.get()));
	}
	
	@PostMapping()
	@Transactional
	public ResponseEntity<Game> create(@RequestBody GameForm form) {
		Game g = form.toGame();
		
		Optional<Game> gameFromRepo = gameService.findByName(form.getName());
		
		if(gameFromRepo.isPresent())
			return ResponseEntity.badRequest().build();

		gameService.save(g);

		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(g.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
}
