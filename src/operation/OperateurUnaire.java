package operation;

import java.util.Stack;

import yaka.Constante;
import yaka.IdConst;
import yaka.Ident;

public abstract class OperateurUnaire extends Operateur {

	@Override
	public void consume(Stack<Ident> pileValeur) {
		// l'élément que l'on va étudier est le dernier sur la pile
		Ident id = pileValeur.pop();
		if(id.getType() == Constante.ERREUR || !this.accepteType(id.getType())) {
			// TODO: générer erreur de type
			pileValeur.add(new IdConst(Constante.ERREUR));
			System.out.println("Erreur de type");
		}
		else {
			// les opérateurs unaires ne changent pas le type : on ré-empile donc l'ancienne Ident
			pileValeur.add(new IdConst(this.typeResultat()));
		}
	}

}
