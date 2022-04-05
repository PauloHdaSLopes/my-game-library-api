package br.com.home.gameLibrary.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SearchQueue")
public class SearchQueue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String searchTerm;
	private LocalDate createdAt = LocalDate.now();
	private LocalDate updatedAt;
	private boolean hasExecuted = false;
	
	public SearchQueue() {

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDate getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}
	public boolean getHasExecuted() {
		return hasExecuted;
	}
	public void setHasExecuted(boolean hasExecuted) {
		this.hasExecuted = hasExecuted;
	}

	@Override
	public String toString() {
		return "SearchQueue [id=" + id + ", searchTerm=" + searchTerm + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", hasExecuted=" + hasExecuted + "]";
	}
}
