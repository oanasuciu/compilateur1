package concept.expression.operation;

import java.util.Stack;

import yaka.Constante;
import yaka.Yaka;
import concept.ident.IdConst;
import concept.ident.Ident;

public abstract class OperateurBinaire extends Operateur {

	@Override
	public void consume(Stack<Ident> pileValeur) {
		// l'élément que l'on va étudier est le dernier sur la pile
		Ident id2 = pileValeur.pop();
		Ident id1 = pileValeur.pop();
		if (id1.getType() == Constante.ERREUR || id2.getType() == Constante.ERREUR) {
			// si un des deux a déjà le type erreur, le résultat de l'opération va en hériter
			pileValeur.add(new IdConst(Constante.ERREUR));
		} else if (id1.getType() != id2.getType()) {
			// si une des 2 opérandes n'est pas de même type, on génère une erreur (p. 11, 2è parag)
			Yaka.em.mauvaisType(this, id1, id2);
			pileValeur.add(new IdConst(Constante.ERREUR));
		} else if (this.accepteType(id1.getType())) {
			// pas d'erreur, on empile le résultat
			pileValeur.add(new IdConst(this.typeResultat()));
		} else {
			// si l'opérateur n'est pas compatible avec le type des opérandes, on génère une erreur (p. 11)
			Yaka.em.mauvaisType(this, id1, id2);
			pileValeur.add(new IdConst(Constante.ERREUR));
		}
	}
}
