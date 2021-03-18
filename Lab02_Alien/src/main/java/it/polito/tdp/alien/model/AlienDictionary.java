package it.polito.tdp.alien.model;


import java.util.LinkedList;



public class AlienDictionary {
	
	private LinkedList<Word> dizionario;
	
	public AlienDictionary() {
		dizionario = new LinkedList<>();
	}
	
	public void addParola(String parola, String traduzione) {
		if(cercaTraduzione(parola) != null) {
			cercaTraduzione(parola).add(traduzione);
		}
		else {
			Word w = new Word(parola, traduzione);
			dizionario.add(w);
		}
	}

	public LinkedList<String> cercaTraduzione(String parola) {
		for(Word w : dizionario) {
			if(w.getParola().equals(parola)) {
				return w.getTraduzione();
			}
		}
		return null;
	}
	
	public LinkedList<String> cercaWildCard(String parola) {
		LinkedList<String> wild = new LinkedList<String>();
		int num = 0;
		boolean trovato = false;
		
		for(Word w : dizionario) {
			
			String[] array1 = parola.split("");
			String[] array2 = w.getParola().split("");
			for(int i = 0; i < parola.length(); i++) {
				String s1 = array1[i];
				String s2 = array2[i];
				if(s1.equals(s2)) {
					num++;
				}
				else {
					if(s1.equals("?") && trovato == false) {
						num++;
						trovato = true;
					}
					else {
						return null;
					}
				}
			}
			if(num == parola.length()) {
				wild.add(w.getParola());
			}
		}
		return wild;
	}
	
	
	
	public void reset() {
		dizionario.clear();
	}
}
