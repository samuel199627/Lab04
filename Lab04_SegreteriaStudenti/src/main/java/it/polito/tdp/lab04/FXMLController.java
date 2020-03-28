package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> corsiMenu;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;

    @FXML
    void cercaCorsi(ActionEvent event) {

    }

    @FXML
    void cercaIscritti(ActionEvent event) {

    }

    @FXML
    void choiseCorso(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void iscrivi(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert corsiMenu != null : "fx:id=\"corsiMenu\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        
       
        //dobbiamo inizializzare i corsi nel menu a tendina a quelli che sono disponibili
        //il problema e' che non possiamo farlo qui perche' il modello a questo punto non e' ancora stato
        //caricato come ho verificato con una stringa in EntryPoint. Per cui dobbiamo andare a 
        //eseguire il caricamento quando settiamo il modello
        //System.out.println("CIAO1\n");
        //List<Corso> ritorna=model.getTuttiICorsi();
		/*
		for(Corso c:ritorna) {
			System.out.println(c.toString());
		}
		*/
        //corsiMenu.getItems().addAll(model.getTuttiICorsi());
        

    }

	public void setModel(Model model) {
		// TODO Auto-generated method stub
		this.model=model;
		//dobbiamo inizializzare i corsi nel menu a tendina a quelli che sono disponibili
        /*
        List<Corso> ritorna=model.getTuttiICorsi();
		for(Corso c:ritorna) {
			System.out.println(c.toString());
		}
		*/
		corsiMenu.getItems().add("Nessun corso");
        corsiMenu.getItems().addAll(model.getTuttiICorsiStringa());
        
	}
    
    
    
}
