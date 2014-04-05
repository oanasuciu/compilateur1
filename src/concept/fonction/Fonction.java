package concept.fonction;

import java.util.ArrayList;
import java.util.Iterator;

import concept.ident.IdVar;
import concept.ident.Ident;
import type.Type;

public class Fonction {
	private String nom;
	private Type retour;
	private ArrayList<Ident> params;
	private int rangParam;
	private Iterator<Ident> iteratorParamsAttendus;

	public Fonction() {
		super();
		this.rangParam = 1;
	}

	public void ajouterParam(String nom, Type type) {
		Ident id = new IdVar(nom, type);
		id.setValeur(this.rangParam);
		this.rangParam++;
		this.params.add(id);
	}
	
	public void setOffset() {

		Iterator<Ident> tabId = this.params.iterator();
		while (tabId.hasNext()) {
			Ident curId = tabId.next();
			curId.setValeur(this.params.size()+4-(curId.getValeur()*2));
		}
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getRetour() {
		return this.retour;
	}

	public void setRetour(Type retour) {
		this.retour = retour;
	}

	public ArrayList<Ident> getParams() {
		return this.params;
	}

	public void initVerifParam() {
		this.iteratorParamsAttendus = this.getParams().iterator();
	}
}