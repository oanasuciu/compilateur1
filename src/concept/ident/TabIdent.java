package concept.ident;

import java.util.HashMap;
import java.util.Iterator;

import yaka.Yaka;

/*
 * TODO: Documenter cette fonction, notamment : qu'est-ce qu'elle renvoie quand pas d'élément trouvé ?
 */
public class TabIdent {
	private HashMap<String, Ident> table;

	public TabIdent() {
		this.table = new HashMap<String, Ident>();
	}

	public Ident chercheIdent(String clef) {
		return table.get(clef);
	}

	public boolean existeIdent(String clef) {
		return table.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id) {
		Ident oldIdent = table.put(clef, id);
		// oldIdent contient l'ancienne valeur qui était dans le HashMap à cette clef
		// si elle n'est pas nulle, c'est qu'on écrase une Ident !
		if(oldIdent != null) {
			Yaka.em.ecraseIdentificateur(clef);
		}
	}
	
	public int nbVar(){
		int cpt=0;
		Iterator<Ident> i = table.values().iterator();
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
		return "TabIdent [table=" + table + "]";
	}
	
	public void reInit() {
		this.table.clear();
	}
}
