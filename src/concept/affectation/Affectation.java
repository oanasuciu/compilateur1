package concept.affectation;

import yaka.Constante;
import yaka.Yaka;
import concept.ident.IdVar;
import concept.ident.Ident;

public class Affectation {
	private Ident affecterDans;
	
	public void setAffecterDans(String ident) {
		Ident id = Yaka.tabIdent.chercheIdent(ident);
		if(id == null) {
			// identificateur inexistant : gestion de l'erreur
			Yaka.em.identificateurInexistant(ident);
			id = new IdVar(Constante.ERREUR);
		}
		this.affecterDans = id;
	}
	
	public void faitAffectation() {
		Ident id = Yaka.expression.recupereTete();
		if(id == null) {
			Yaka.em.aucuneValeurAAffecter();
			return;
		}
		this.affecterDans.affectation(id);
	}
}