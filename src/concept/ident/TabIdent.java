package concept.ident;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

import concept.fonction.Fonction;
import yaka.Yaka;

public class TabIdent {
	private HashMap<String, Ident> locaux;
	private HashMap<String, Fonction> globaux; 
	
	public TabIdent() {
		this.locaux = new HashMap<String, Ident>();
		this.globaux = new HashMap<String, Fonction>();
	}

	public Ident chercheIdent(String clef) {
		return locaux.get(clef);
	}

	public Fonction chercheFonction(String clef) {
		return globaux.get(clef);
	}
	
	public boolean existeIdent(String clef) {
		return locaux.containsKey(clef);
	}
	
	public boolean existeFonction(String clef) {
		return globaux.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id) {
		Ident oldIdent = locaux.put(clef, id);
		// oldIdent contient l'ancienne valeur qui était dans le HashMap à cette clef
		// si elle n'est pas nulle, c'est qu'on écrase une Ident !
		if(oldIdent != null) {
			Yaka.em.ecraseIdentificateur(clef);
		}
	}
	
	public void rangeFonction(Fonction f) {
		Fonction oldFonction = this.globaux.put(f.getNom(), f);
		// oldIdent contient l'ancienne valeur qui était dans le HashMap à cette clef
		// si elle n'est pas nulle, c'est qu'on écrase une Ident !
		if(oldFonction != null) {
			Yaka.em.ecraseFonction(f.getNom());
		}
	}
	
	public int nbVar(){
		int cpt=0;
		Iterator<Ident> i = locaux.values().iterator();
		while (i.hasNext()){
			Ident id = i.next();
			if(id.isVar()) {
				cpt++;
			}
		}
		return cpt;
	}
	
	public void ouvrePrinc() {
		Yaka.yvm.ouvrePrinc(Yaka.tabIdent.nbVar() * 2);
	}

	@Override
	public String toString() {
		return "TabIdent [table=" + locaux + "]";
	}
	
	public void ouvertureFonction(){
		this.locaux = new HashMap<String, Ident>();
	}
	
	public void reInit() {
		this.locaux.clear();
		this.globaux.clear();
	}
}
