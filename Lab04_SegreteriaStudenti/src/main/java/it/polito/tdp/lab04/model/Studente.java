package it.polito.tdp.lab04.model;

public class Studente {

	Integer matricola;
	String cognome;
	String Nome;
	String corsoStudi;
	
	public Studente(Integer matricola, String cognome, String nome, String corsoStudi) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		Nome = nome;
		this.corsoStudi = corsoStudi;
	}

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCorsoStudi() {
		return corsoStudi;
	}

	public void setCorsoStudi(String corsoStudi) {
		this.corsoStudi = corsoStudi;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", cognome=" + cognome + ", Nome=" + Nome + ", corsoStudi="
				+ corsoStudi + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}
	
	
	
}
