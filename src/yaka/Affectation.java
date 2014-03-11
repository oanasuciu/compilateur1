package yaka;

public class Affectation {
	private Ident affecterDans;
	
	public void setAffecterDans(String ident) {
		Ident id = Yaka.tabIdent.chercheIdent(ident);
		if(id == null) {
			// identificateur inexistant : gestion de l'erreur
			Yaka.em.identificateurInexistant(ident);
			id = new IdConst(Constante.ERREUR);
		}
		this.affecterDans = id;
	}
	
	public void faitAffectation() {
		Ident id = Yaka.expression.recupereTete();
		if(id == null) {
			Yaka.em.aucuneValeurAAffecter();
			return;
		}
		// on regarde si les types sont compatibles :
		if(id.getType() != Constante.ERREUR && this.affecterDans.getType() != Constante.ERREUR && id.getType() != this.affecterDans.getType()) {
			Yaka.em.mauvaisTypeAffectation(this.affecterDans, id);
			return;
		}
		// on regarde si l'Identificateur auquel on veut affecter la valeur est bien une variable
		if(this.affecterDans.getType() != Constante.ERREUR && !this.affecterDans.isVar()) {
			Yaka.em.affectationDansConstante(this.affecterDans);
			return;
		}
		Yaka.yvm.istore(affecterDans.getValeur());
	}
}