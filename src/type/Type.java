package type;

import concept.es.Sortie;

abstract public class Type {
	private String nom;

	public Type(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	abstract public void visiteEcriture(Sortie s);
}