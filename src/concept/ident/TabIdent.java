package concept.ident;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

import yaka.Yaka;

/*
 * TODO: Documenter cette fonction, notamment : qu'est-ce qu'elle renvoie quand pas d'élément trouvé ?
 */
public class TabIdent {
	private HashMap<String, Ident> locaux;
	private HashMap<String, Ident> globaux;
	private Stack<HashMap<String, Ident>> pileHash = new Stack<HashMap<String, Ident>>(); 
	
	public TabIdent() {
		this.locaux = new HashMap<String, Ident>();
		this.globaux = new HashMap<String, Ident>();
		
	}

	public Ident chercheIdent(String clef) {
		return locaux.get(clef);
	}
	

	public boolean existeIdent(String clef) {
		return locaux.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id) {
		Ident oldIdent = locaux.put(clef, id);
		// oldIdent contient l'ancienne valeur qui était dans le HashMap à cette clef
		// si elle n'est pas nulle, c'est qu'on écrase une Ident !
		if(oldIdent != null) {
			Yaka.em.ecraseIdentificateur(clef);
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
	
	public void reInit() {
		this.locaux.clear();
	}
	
	public void ouvertureFonction(){
		this.pileHash.add(locaux);
		this.locaux = new HashMap<String, Ident>();
	}
	
	public void fermetureFonction(){
		this.locaux = this.pileHash.pop();
	}
}
