package concept.ident;

import java.util.ArrayList;

import type.Type;

public abstract class Ident {
	protected String nom;
	public Type type;

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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Donne le nom du type d'Ident
	 * 
	 * @return le nom du type d'Ident (fonction, variable, constante)
	 */
	abstract public String getTypeIdent();
	
	abstract public boolean isVar();
	
	/**
	 * Appelle la bonne opération pour charger une valeur (iconst, iload)
	 */
	abstract public void chargeValeur();
	
	/**
	 * Appelle la bonne opération pour affecter dans une Ident (istore), ou signale une erreur
	 */
	abstract public void affectation(Ident partieDroite);

	abstract public Ident dupliqueConstante();
	
	abstract public void lireEntier();

	abstract public ArrayList<IdVar> getParams();
}