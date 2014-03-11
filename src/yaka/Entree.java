package yaka;

public class Entree {
	public void lireIdent(String ident) {
		Ident id = Yaka.tabIdent.chercheIdent(ident);
		if(id == null) {
			// identificateur inexistant : gestion de l'erreur
			Yaka.em.identificateurInexistant(ident);
			id = new IdConst(Constante.ERREUR);
			return;
		}
		if(id.getType() != Constante.ERREUR && !id.isVar()) {
			Yaka.em.affectationDansConstante(id);
			return;
		}
		Yaka.yvm.lireEnt(id.getValeur());
	}
}
