package concept.es;

import yaka.Yaka;
import concept.ident.Ident;

public class Entree {
	public void lireIdent(String ident) {
		Ident id = Yaka.tabIdent.chercheIdent(ident);
		if(id == null) {
			// identificateur inexistant : gestion de l'erreur
			Yaka.em.identificateurInexistant(ident);
			return;
		}
		id.lireEntier();
	}
}
