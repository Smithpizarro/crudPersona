package com.invpersona.crudPersona.integration.dto;

import java.util.List;

public class SearchPlanetDTO {
  
	public int count;
	public String next;
	public String previous;
	
    public List<personDTO> 	results;
	
	
	public List<personDTO> getResults() {
		return results;
	}
	public void setResults(List<personDTO> results) {
		this.results = results;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}


}
