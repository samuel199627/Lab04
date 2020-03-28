package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {
	
	CorsoDAO corsoDao;

	public Model() {
		super();
		this.corsoDao = new CorsoDAO();
	}
	
	public List<Corso> getTuttiICorsi(){
		
		return corsoDao.getTuttiICorsi();
	}
	
	//allora questo metodo lo uso per caricare il menu dei voti con solo i nomi dei corsi
	public List<String> getTuttiICorsiStringa(){
		
		List<Corso> ritornata= corsoDao.getTuttiICorsi();
		List<String> ritornare= new LinkedList<>();
		
		for(Corso c:ritornata) {
			ritornare.add(c.getNome());
		}
		//Ritorniamo in ordine alfabetico le stringhe dei nomi dei corsi per avere un ordinamento
		//piu' elegante in vista dell'interfaccia grafica
		ritornare.sort(null);
		return ritornare;
		
	}
	
	

}
