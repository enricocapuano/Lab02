package it.polito.tdp.alien.model;

import java.util.LinkedList;

public class Word {
	
	private String parola;
	private LinkedList<String> traduzione;
	
	public Word(String parola, String traduzione) {
		super();
		this.parola = parola;
		this.traduzione = new LinkedList<>();
		this.traduzione.add(traduzione);
	}
	
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public LinkedList<String> getTraduzione() {
		return traduzione;
	}
	public void setTraduzione(LinkedList<String> traduzione) {
		this.traduzione = traduzione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	

	
	

}