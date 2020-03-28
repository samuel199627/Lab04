package it.polito.tdp.lab04.DAO;

public class TestDB {
	
	//questa e' una classe per testare se la connessione al database da problemi oppure se
	//funziona e restituisce qualcosa

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		
	}

}
