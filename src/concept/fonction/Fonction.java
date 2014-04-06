package concept.fonction;

import yaka.Constante;
import yaka.Yaka;
import concept.ident.Ident;

public class Fonction {
	public void retourne() {
		Ident identAttendue = Yaka.declaration.getFonctionCourante();
		Ident identFournie = Yaka.expression.recupereTete();
		if(identFournie.getType() != Constante.ERREUR && identFournie.getType() != identAttendue.getType()) {
			Yaka.em.retourInvalide(identAttendue, identFournie);
			return;
		}
		// L'espace prévu pour le retour de la fonction est tout en bas de la pile, soit après tous les params (qui commencent à l'offset 4), donc : nb(Params) + 4 octets
		Yaka.yvm.ireturn((identAttendue.getParams().size() * 2) + 4);
	}
}
