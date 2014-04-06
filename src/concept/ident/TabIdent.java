package concept.ident;

import java.util.HashMap;
import java.util.Iterator;

import yaka.Yaka;

public class TabIdent {
	private HashMap<String, Ident> locaux;
	private HashMap<String, Ident> globaux; 
	
	public TabIdent() {
		this.locaux = new HashMap<String, Ident>();
		this.globaux = new HashMap<String, Ident>();
	}

	public Ident chercheIdent(String clef) {
		Ident idLocaux = locaux.get(clef);
		if(idLocaux != null)
			return idLocaux;
		else {
			return globaux.get(clef);
		}
	}
	
	public boolean existeIdent(String clef) {
		return locaux.containsKey(clef) || globaux.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id) {
		Ident oldIdent = this.locaux.put(clef, id);
		// oldIdent contient l'ancienne valeur qui était dans le HashMap à cette clef
		// si elle n'est pas nulle, c'est qu'on écrase une Ident !
		if(oldIdent != null) {
			Yaka.em.affectation.ecraseIdentificateur(clef);
		}
	}
	
	public void rangeFonction(String clef, Ident id) {
		Ident oldIdent = this.globaux.put(clef, id);
		// oldIdent contient l'ancienne valeur qui était dans le HashMap à cette clef
		// si elle n'est pas nulle, c'est qu'on écrase une Ident !
		if(oldIdent != null) {
			Yaka.em.affectation.ecraseIdentificateur(clef);
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
	
	public void nettoieLocaux() {
		this.locaux.clear();
	}
	
	public void ouvreBloc() {
		IdFonction fonc = Yaka.declaration.getFonctionCourante();
		if(fonc != null)
			Yaka.yvm.ouvreBloc((this.nbVar()-fonc.getParams().size()) * 2);
		else
			Yaka.yvm.ouvreBloc(this.nbVar() * 2);
	}
	
	public void fermeBloc() {
		Yaka.yvm.fermeBloc(Yaka.declaration.getFonctionCourante().getParams().size() * 2);
	}

	@Override
	public String toString() {
		return "TabIdent [table=" + locaux + "]";
	}
	
	public void reInit() {
		this.locaux.clear();
		this.globaux.clear();
	}
}
