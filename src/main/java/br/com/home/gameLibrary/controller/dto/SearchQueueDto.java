package br.com.home.gameLibrary.controller.dto;

import java.time.LocalDate;

import br.com.home.gameLibrary.model.SearchQueue;

public class SearchQueueDto {

	private Long id;
	private String searchTerm;
	private LocalDate createdAt = LocalDate.now();
	private LocalDate updatedAt;
	private boolean hasExecuted = false;
	
	public SearchQueueDto(SearchQueue search) {
		this.id = search.getId();
		this.searchTerm = search.getSearchTerm();
		this.createdAt = search.getCreatedAt();
		this.updatedAt = search.getUpdatedAt();
		this.hasExecuted = search.getHasExecuted();
	}

	public Long getId() {
		return id;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public boolean isHasExecuted() {
		return hasExecuted;
	}
	
}
