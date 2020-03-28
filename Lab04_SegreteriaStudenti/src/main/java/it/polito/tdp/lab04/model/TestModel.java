package it.polito.tdp.lab04.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		//proviamo a ritornare tutti i corsi della tabella corso
		/*
		List<Corso> ritorna=model.getTuttiICorsi();
		for(Corso c:ritorna) {
			System.out.println(c.toString());
		}
		*/
		
		//proviamo a ritornare tutti gli studenti di studente
		/*
		List<Studente> ritorna=model.getTuttiStudenti();
		int conta=1;
		for(Studente s:ritorna) {
			System.out.println(""+conta+" "+s.toString());
			conta++;
		}
		*/
		
		List<Studente> ritorna=model.getStudentiIscrittiAlCorso("Diritto commerciale");
		//System.out.println("CIAO1");
		int conta=1;
		for(Studente s:ritorna) {
			System.out.println(""+conta+" "+s.toString());
			conta++;
		}
		//System.out.println("CIAO2");
	}

}
