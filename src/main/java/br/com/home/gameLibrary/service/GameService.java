package br.com.home.gameLibrary.service;

import br.com.home.gameLibrary.controller.dto.GameDto;
import br.com.home.gameLibrary.model.Game;
import br.com.home.gameLibrary.repository.GameRepository;
import br.com.home.gameLibrary.repository.GameTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GameTimeRepository timeRepository;

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }
    public Optional<Game> findByName(String name) {
        return gameRepository.findByName(name);
    }

    public void create(String name, String description, String[] genre, Integer rating) {
        Game game = new Game(null, name, description, genre, rating);
        gameRepository.save(game);
    }

    public void save(Game g) {
        gameRepository.save(g);
        timeRepository.saveAll(g.getGameTimes());
    }
}
