package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				/*
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				*/
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd")));
				
			}

			st.close();
			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/*
	 * Dato il nome del corso, ottengo il corso
	 */
	public Corso getCorso(String nomeCorso) {
		// TODO
		final String sql = "SELECT * FROM corso where nome='"+nomeCorso+"'";

		Corso corso = null;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				/*
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				*/
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corso= new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				
			}

			st.close();
			conn.close();
			
			return corso;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
		/*
	 	select s.matricola, s.cognome, s.nome, s.cds 
		from corso as c, iscrizione i, studente as s 
		where c.codins = i.codins and i.matricola=s.matricola and c.codins = '01KSUPG'
		*/
		final String sql = "select s.matricola, s.cognome, s.nome, s.cds "+
				"from corso as c, iscrizione i, studente as s "+
				"where c.codins = i.codins and i.matricola=s.matricola and c.codins = '"+corso.getCodIns()+"'";
		
		//System.out.println(sql);

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				/*
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				*/
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				studenti.add(new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS")));
				
			}

			st.close();
			conn.close();
			
			return studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean iscriviStudenteACorso(Integer matricola, String codIns) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		/*
		 INSERT INTO `iscrizione` (`matricola`, `codins`) VALUES
		(161245, '01KSUPG')
		 */
		final String sql="INSERT INTO `iscrizione` (`matricola`, `codins`) VALUES " + 
				"	("+matricola+", '"+codIns+"')";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			st.close();
			conn.close();
			
			return true;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
			//throw new RuntimeException("Errore Db", e);
		}
		
		//return false;
	}
	
	/**
	 * 
	 * @param matricola dello studente per cui stiamo ricercando i corsi
	 * @return lista di corsi associati allo studente
	 */
	public List<Corso> getTuttiICorsiStudente(Integer matricola) {

		/*
		  	select c.codins, c.nome, c.crediti, c.pd 
			from corso as c, iscrizione i, studente as s 
			where c.codins = i.codins and i.matricola=s.matricola and s.matricola ='146101'
		 */
		final String sql = "select c.codins, c.nome, c.crediti, c.pd "+
				"from corso as c, iscrizione i, studente as s "+
				"where c.codins = i.codins and i.matricola=s.matricola and s.matricola = '"+matricola+"'";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				/*
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				*/
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd")));
				
			}

			st.close();
			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	

}
