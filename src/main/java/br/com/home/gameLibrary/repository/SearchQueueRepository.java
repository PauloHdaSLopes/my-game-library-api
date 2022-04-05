package br.com.home.gameLibrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.home.gameLibrary.model.SearchQueue;

public interface SearchQueueRepository extends JpaRepository<SearchQueue, Long>{

	@Query("SELECT s FROM SearchQueue s WHERE s.hasExecuted = false")
	public Optional<SearchQueue> findNext();
	
	public Optional<SearchQueue> findFirstByHasExecuted(boolean hasExecuted);

}
