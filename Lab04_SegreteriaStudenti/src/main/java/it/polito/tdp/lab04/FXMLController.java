package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
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
    private Button btnInsert;

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

    	corsiMenu.setValue("Nessun Corso");
    	//data la matricola dello studente completare con nome e cognome
    	txtNome.clear();
    	txtCognome.clear();
    	txtRisultato.clear();
    	
    	//recuperiamo la matricola inserita
    	String matricolaString = txtMatricola.getText();

    	//usiamo la classe java base quindi il confronto lo si fa con equals
    	Integer matricola;

    	//verifichiamo che sia stato inserito un numero nel riquadro del periodo
    	try {
    		matricola = Integer.parseInt(matricolaString);
    	} catch (NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un numero per la matricola!");
    		return;
    		
    	}
    	
    	//possiamo avere due casi di errore in cui lo studente passato non e' nel database e quindi la matricola
    	//che abbiamo passato non si trova in studenti
    	//oppure lo studente si trova nel database ma non e' collegato a nessun corso
    	List<Studente> ritorna = model.getTuttiStudenti();
    	boolean esistente=false;
    	for(Studente s: ritorna) {
    		if(s.getMatricola().equals(matricola)) {
    			txtNome.setText(s.getNome());
    			txtCognome.setText(s.getCognome());
    			esistente=true;
    		}
    	}
    	//studente non esistente
    	if(esistente==false) {
    		txtRisultato.setText("La matricola che hai passato come parametro non e' registrata tra gli studenti!");
    		return;
    	}
    	
    	List<Corso> ritornaCorsi=model.getTuttiICorsiStudente(matricola);
    	/*
    	 	select s.matricola
			from studente as s 
			where s.matricola NOT IN (select i.matricola
										from iscrizione as i)
			non ha restituito nessuna riga e dunque tutti gli studenti sono associati ad un corso
			allora mi sono inserito senza associarmi a nessun corso
			INSERT INTO `studente` (`matricola`, `cognome`, `nome`, `CDS`) VALUES
			(7, 'GRASSI', 'SAMUEL', 'INGMAT');
			//quindi ora abbiamo lo studente non iscritto ad alcun corso e la condizione qui sotto funziona
    	 */
    	if(ritornaCorsi.size()==0) {
    		txtRisultato.setText("Nessun corso associato allo studente passato!");
    	}
    	for(Corso c: ritornaCorsi) {
    		txtRisultato.appendText(c.toString()+"\n");
    	}
    	
    	
    }

    @FXML
    void cercaIscritti(ActionEvent event) {
    	txtRisultato.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	//Dobbiamo restituire tutti gli studenti del corso scelto con il menu a tendina
    	//txtRisultato.setText("Ciao");
    	//questa stringa la devo passare in un'istruzione SQL
    	String nomeCorso= corsiMenu.getValue();
    	if(nomeCorso==null) {
    		txtRisultato.setText("NESSUN CORSO SELEZIONATO!!!");
    		return;
    	}
    	if(nomeCorso.equals("Nessun corso")) {
    		txtRisultato.setText("NESSUN CORSO SELEZIONATO!!!");
    		return;
    	}
    	
    	//se abbiamo inserito una matricola nel campo, dobbiamo cercare se quello studente e' iscritto al corso piuttosto che 
    	//tutti gli studenti iscritti a quel corso
    	String matricolaString = txtMatricola.getText();
    	if(matricolaString.equals("")) { //se nel campo matricola non ho inserito nulla allora ricerco tutti gli studenti per quel corso
	    	List<Studente> ritorna=model.getStudentiIscrittiAlCorso(nomeCorso);
	    	//int conta=1;
	    	if(ritorna.size()==0) {
	    		txtRisultato.appendText("Nessuno studente iscritto al corso");
	    	}
	    	for(Studente s:ritorna) {
	    		//txtRisultato.appendText(""+conta+" "+s.toString()+"\n");
	    		txtRisultato.appendText(s.toString()+"\n");
	    		//conta++;
	    	}
    	}
    	else {
    		//recuperiamo la matricola inserita
        	

        	//usiamo la classe java base quindi il confronto lo si fa con equals
        	Integer matricola;

        	//verifichiamo che sia stato inserito un numero nel riquadro del periodo
        	try {
        		matricola = Integer.parseInt(matricolaString);
        	} catch (NumberFormatException e) {
        		txtRisultato.setText("Devi inserire un numero per la matricola!");
        		return;
        		
        	}
        	
        	//devo ricercare tra gli studenti del corso selezionato, la matricola inserita
        	//per completezza verifichiamo che lo studente sia esistente
        	List<Studente> ritorna = model.getTuttiStudenti();
        	boolean esistente=false;
        	for(Studente s: ritorna) {
        		if(s.getMatricola().equals(matricola)) {
        			txtNome.setText(s.getNome());
        			txtCognome.setText(s.getCognome());
        			esistente=true;
        		}
        	}
        	//studente non esistente
        	if(esistente==false) {
        		txtRisultato.setText("La matricola che hai passato come parametro non e' registrata tra gli studenti!");
        		return;
        	}
        	
        	List<Studente> ritornaStud=model.getStudentiIscrittiAlCorso(nomeCorso);
	    	//int conta=1;
	    	for(Studente s:ritornaStud) {
	    		if(s.getMatricola().equals(matricola)) {
	    			txtRisultato.setText("Studente gia' iscritto a questo corso");
	    			return;
	    		}	
	    	}
	    	txtRisultato.setText("Studente non ancora iscritto a questo corso");
        	
        	
    	}
    	
    	
    }

    @FXML
    void choiseCorso(ActionEvent event) {
    	
    	//questa in realta' non serviva perche' quando scelgo un corso dal menu a tendina
    	//txtRisultato.appendText("CIAO ");
    	//sfruttiamo per pulire il campo matricola
    	txtMatricola.clear();
    	txtRisultato.clear();
    	txtNome.clear();
    	txtCognome.clear();
    }
    
    @FXML
    void doInsert(ActionEvent event) {

    	//data la matricola dello studente completare con nome e cognome
    	txtNome.clear();
    	txtCognome.clear();
    	txtRisultato.clear();
    	
    	//recuperiamo la matricola inserita
    	String matricolaString = txtMatricola.getText();

    	//usiamo la classe java base quindi il confronto lo si fa con equals
    	Integer matricola;

    	//verifichiamo che sia stato inserito un numero nel riquadro del periodo
    	try {
    		matricola = Integer.parseInt(matricolaString);
    	} catch (NumberFormatException e) {
    		txtRisultato.setText("Devi inserire un numero per la matricola!");
    		return;
    	}
    	
    	
    	Studente ritornato=model.getStudenteDaMatricola(matricola);
    	if(ritornato!=null) {
    		txtNome.setText(ritornato.getNome());
    		txtCognome.setText(ritornato.getCognome());
    	}
    	else {
    		txtNome.setText("INESISTENTE");
    		txtCognome.setText("INESISTENTE");
    	}
    	
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
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'Scene.fxml'.";
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
    	/*
    	 	select c.nome
			from corso as c 
			where c.codins NOT IN (select i.codins
										from iscrizione as i)
			non restituisce nessuna riga dunque per gestire il caso di corsi senza iscritti mi sono creato un nuovo corso 
			che non associo a nessun iscritto
			INSERT INTO `corso` (`codins`, `crediti`, `nome`, `pd`) VALUES
			('123', 8, 'Corso senza iscritti', 2)
    	 */
    	corsiMenu.getItems().add("Nessun corso");
        corsiMenu.getItems().addAll(model.getTuttiICorsiStringa());
        //corsiMenu.setValue("Nessun corso");
        
    }
    
    
    
}








