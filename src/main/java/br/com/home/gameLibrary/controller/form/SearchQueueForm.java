package br.com.home.gameLibrary.controller.form;

import javax.validation.constraints.NotNull;

import br.com.home.gameLibrary.model.SearchQueue;

public class SearchQueueForm {
	
	@NotNull
	private String searchTerm;

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	public SearchQueue toSearchQueue() {
		SearchQueue search = new SearchQueue();
		search.setSearchTerm(this.getSearchTerm());
		
		return search;
	}
}
