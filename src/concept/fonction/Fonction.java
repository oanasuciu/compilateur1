package concept.fonction;

import yaka.Constante;
import yaka.Yaka;
import concept.ident.Ident;

public class Fonction {
	public void retourne() {
		Ident identAttendu = Yaka.declaration.getFonctionCourante();
		Ident identFourni = Yaka.expression.recupereTete();
		if(identFourni.getType() != Constante.ERREUR && identFourni.getType() != identAttendu.getType()) {
			Yaka.em.fonction.retourInvalide(identAttendu, identFourni);
			return;
		}
		// L'espace prévu pour le retour de la fonction est tout en bas de la pile, soit après tous les params (qui commencent à l'offset 4), donc : nb(Params) + 4 octets
		Yaka.yvm.ireturn((identAttendu.getParams().size() * 2) + 4);
	}
}
