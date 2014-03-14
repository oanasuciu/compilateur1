package concept.ident;

import generation.YVM;
import type.Type;

public abstract class Ident {
	protected String nom;
	public Type type;
	public int valeur;

	public Ident(String nom) {
		this.nom = nom;
	}

	public Ident(Type type) {
		this.type = type;
	}

	public Ident(String nom, Type type) {
		this.nom = nom;
		this.type = type;
	}

	public Ident(String nom, Type type, int valeur) {
		this.nom = nom;
		this.type = type;
		this.valeur = valeur;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public String getNom() {
		return nom;
	}

	/**
	 * Getter pour l'attribut valeur
	 * 
	 * @return valeur de l'identificateur courant
	 */
	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public void setValeur(boolean valeur) {
		this.valeur = (valeur) ? -1 : 0;
	}
	
	abstract public boolean isVar();
	
	/**
	 * A partir d'une instance de YVM, appelle la bonne opération (iconst, iload)
	 * 
	 * @param yvm
	 * 			L'instance de la YVM sur laquelle appeler l'opération
	 * 
	 */
	abstract public void visiteYVM(YVM yvm);
}