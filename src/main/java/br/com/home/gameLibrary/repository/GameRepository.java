package br.com.home.gameLibrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.home.gameLibrary.model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

	public Optional<Game> findByName(String name);
}
