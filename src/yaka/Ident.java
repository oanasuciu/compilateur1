package yaka;

import type.Type;

public abstract class Ident {
	protected String nom;
	protected Type type;
	protected int valeur;

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
	
	/**
	 * Renvoie le texte pour le chargement de l'identité dans la YVM selon le type de l'identificateur (variable/constante)
	 * 
	 * @return le texte correspondant au type de l'identificateur
	 */
	abstract public String getYVMText();
}