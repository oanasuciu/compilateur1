package operation;

import java.util.Stack;

import yaka.Constante;
import yaka.IdConst;
import yaka.Ident;

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
			// TODO: générer erreur de type
			System.out.println("Erreur de type");
			pileValeur.add(new IdConst(Constante.ERREUR));
		} else if (this.accepteType(id1.getType())) {
			// pas d'erreur, on empile le résultat
			pileValeur.add(new IdConst(this.typeResultat()));
		} else {
			// si l'opérateur n'est pas compatible avec le type des opérandes, on génère une erreur (p. 11)
			// TODO: générer erreur de type
			System.out.println("Erreur de type");
			pileValeur.add(new IdConst(Constante.ERREUR));
		}
	}
}
