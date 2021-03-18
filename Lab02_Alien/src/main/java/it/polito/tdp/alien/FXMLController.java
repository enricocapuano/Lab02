package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienDictionary;
import it.polito.tdp.alien.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dizionario = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtRisultato.clear();
    	txtParola.clear();
    	dizionario.reset();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String parola = txtParola.getText(); 
	    	if(parola.contains(" ")) {
	    		
	    		String campi[] = parola.split(" ");
	    		if(campi[0].matches("[a-zA-Z]*") && campi[1].matches("[a-zA-Z]*")) {
	    			String aliena = campi[0].toLowerCase();
	    			String trad = campi[1].toLowerCase();
	    			dizionario.addParola(aliena, trad);
	    			txtRisultato.setText("Parola aggiunta al dizinario");
	    			txtParola.clear();
	    		}
	    		else {
	    			txtRisultato.setText("Errore nella scrittura della parola: devono essere presenti \nsolo lettere");
	    			txtParola.clear();
	    		}
	 
	    	}
	    	else {
	    		if(parola.matches("[a-zA-Z]*") && !parola.contains("?")) {
	    			String word = parola.toLowerCase();
	    			LinkedList<String> traduzione = dizionario.cercaTraduzione(word);
	    			if(traduzione != null) {
	    				String s = "\n";
	    				for(String t : traduzione) {
	    					s += t+"\n";
	    				}
	    				txtRisultato.setText("La parola "+parola+" significa: "+s);
	    				txtParola.clear();
	    			}
	    			else {
	    				txtRisultato.setText("Errore: parola non presente nel dizionario");
	    				txtParola.clear();
	    			}
	    		}
	    		else if(parola.matches("[a-zA-Z?]*")) {
	    			String word = parola.toLowerCase();
	    			LinkedList<String> wild = dizionario.cercaWildCard(word);
	    				for(String ss : wild) {
		    				LinkedList<String> traduzione = dizionario.cercaTraduzione(ss);
		    				if(traduzione != null) {
			    				String s = "\n";
			    				for(String t : traduzione) {
			    					s += t+"\n";
			    				}
			    				txtRisultato.setText("La parola "+parola+" significa: "+s);
			    				txtParola.clear();
			    			}
			    			else {
			    				txtRisultato.setText("Errore: parola non presente nel dizionario");
			    				txtParola.clear();
			    			}
		    			}
	    			
	    			
	    			
	    		}
	    		else {
	    			txtRisultato.setText("Errore nella scrittura della parola: devono essere presenti solo lettere");
	    			txtParola.clear();
	    		}	    		
	    	}
    }	

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}





