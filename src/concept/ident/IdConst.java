package concept.ident;

import java.util.ArrayList;

import type.Type;
import yaka.Yaka;

public class IdConst extends Ident {
	private int valeur;

	public IdConst(String nom, Type type, int valeur) {
		super(nom, type);
		this.valeur = valeur;
	}

	public IdConst(String nom, Type type) {
		super(nom, type);
	}
	
	public IdConst(Type type) {
		super(type);
	}

	public IdConst(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "IdConst [nom=" + nom + ", type=" + type + ", valeur=" + valeur
				+ "]";
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

	@Override
	public boolean isVar() {
		return false;
	}

	@Override
	public void chargeValeur() {
		Yaka.yvm.iconst(this.valeur);
	}

	@Override
	public void affectation(Ident partieDroite) {
		Yaka.em.affectation.affectationDansConstante(this);
	}

	@Override
	public String getTypeIdent() {
		return "constante";
	}

	@Override
	public Ident dupliqueConstante() {
		return new IdConst(super.nom, super.type, this.valeur);
	}

	@Override
	public void lireEntier() {
		Yaka.em.affectation.affectationDansConstante(this);
	}

	@Override
	public ArrayList<IdVar> getParams() {
		return null;
	}
}
