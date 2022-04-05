package br.com.home.gameLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.home.gameLibrary.model.GameTime;

public interface GameTimeRepository extends JpaRepository<GameTime, Long>{

}
