package br.com.home.gameLibrary.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.home.gameLibrary.controller.dto.SearchQueueDto;
import br.com.home.gameLibrary.controller.form.SearchQueueForm;
import br.com.home.gameLibrary.model.SearchQueue;
import br.com.home.gameLibrary.repository.SearchQueueRepository;

@RestController
@RequestMapping("/search")
public class SearchQueueController {

	@Autowired
	private SearchQueueRepository searchQueueRepository;
	
	@GetMapping
	public List<SearchQueueDto> getAll() {
		List<SearchQueue> searchs = searchQueueRepository.findAll();
		
		return searchs.stream().map(SearchQueueDto::new).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SearchQueueDto> getById(@PathVariable Long id) {
		Optional<SearchQueue> opt = searchQueueRepository.findById(id);
		if(!opt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(new SearchQueueDto(opt.get()));
	}
	
	@GetMapping("/next")
	public ResponseEntity<SearchQueueDto> getNext() {
		Optional<SearchQueue> opt = searchQueueRepository.findFirstByHasExecuted(false);
		
		if(!opt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(new SearchQueueDto(opt.get()));
	}
	
	@PostMapping()
	public ResponseEntity<SearchQueue> create(@RequestBody @Valid SearchQueueForm form) {
		SearchQueue search = form.toSearchQueue();
		searchQueueRepository.save(search);
		
		return ResponseEntity.ok(search);
	}

	@PostMapping("/check/{id}")
	@Transactional
	public ResponseEntity<?> checkExecution(@PathVariable Long id) {
		Optional<SearchQueue> opt = searchQueueRepository.findById(id);
		
		if (!opt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		SearchQueue search = opt.get();
		search.setUpdatedAt(LocalDate.now());
		search.setHasExecuted(true);
		
		return ResponseEntity.ok().build(); 
	}
}