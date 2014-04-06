package concept.ident;

import java.util.ArrayList;

import type.Type;
import yaka.Yaka;

public class IdFonction extends Ident {
	private ArrayList<IdVar> params;
	private int rangParam;

	public IdFonction(String nom) {
		super(nom);
		this.params = new ArrayList<IdVar>();
		this.rangParam = 1;
	}

	public IdFonction(Type type) {
		super(type);
		this.params = new ArrayList<IdVar>();
		this.rangParam = 1;
	}

	public IdFonction(String nom, Type type) {
		super(nom, type);
		this.params = new ArrayList<IdVar>();
		this.rangParam = 1;
	}

	public void ajouterParam(String nom, Type type) {
		IdVar id = new IdVar(nom, type);
		id.setOffset(this.rangParam);
		this.rangParam++;
		this.params.add(id);
	}

	/**
	 * Méthode chargée de mettre les bons offsets aux paramètres
	 */
	public void setParamsOffset() {
		int tailleParams = this.params.size() * 2;
		for(IdVar ident : this.params) {
			ident.setOffset(tailleParams + 4 - (ident.getOffset() * 2));
			Yaka.tabIdent.rangeIdent(ident.getNom(), ident);
		}
		// on réinitialise le compteur d'offset de IdVar
		IdVar.reInit();
	}
	
	@Override
	public boolean isVar() {
		return false;
	}

	@Override
	public void chargeValeur() {
		Yaka.yvm.reserveRetour();
	}

	@Override
	public void affectation(Ident partieDroite) {
		Yaka.em.affectation.affectationDansFonction(this);
	}

	@Override
	public String getTypeIdent() {
		return "fonction";
	}

	@Override
	public Ident dupliqueConstante() {
		return null;
	}

	@Override
	public void lireEntier() {
		Yaka.em.affectation.affectationDansFonction(this);
	}

	@Override
	public ArrayList<IdVar> getParams() {
		return this.params;
	}
}
