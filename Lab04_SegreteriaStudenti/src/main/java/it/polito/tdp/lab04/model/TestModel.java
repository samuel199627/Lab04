package it.polito.tdp.lab04.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		//proviamo a ritornare tutti i corsi della tabella corso
		List<Corso> ritorna=model.getTuttiICorsi();
		
		for(Corso c:ritorna) {
			System.out.println(c.toString());
		}
		
	}

}
