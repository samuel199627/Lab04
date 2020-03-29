package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO corsoDao;
	StudenteDAO studenteDao;

	public Model() {
		super();
		this.corsoDao = new CorsoDAO();
		this.studenteDao=new StudenteDAO();
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
	
	public Studente getStudenteDaMatricola(Integer matricola) {
		List<Studente> studenti= studenteDao.getTuttiStudenti();
		for(Studente s:studenti) {
			if(s.getMatricola().equals(matricola)) {
				return s;
			}
		}
		return null;
	}
	
	public List<Studente> getTuttiStudenti(){
		return studenteDao.getTuttiStudenti();
		
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(String corso){
		List<Corso> ritornata= corsoDao.getTuttiICorsi();
		List<Studente> ritornataS= new LinkedList<>();
		for(Corso c:ritornata) {
			if(c.getNome().equals(corso)) {
				ritornataS= corsoDao.getStudentiIscrittiAlCorso(c);
				break;
			}
		}
		
		return ritornataS;
		
	}
	
	public List<Corso> getTuttiICorsiStudente(Integer matricola){
		return corsoDao.getTuttiICorsiStudente(matricola);
	}
	

}
