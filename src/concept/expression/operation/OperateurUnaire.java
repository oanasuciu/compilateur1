package concept.expression.operation;

import java.util.Stack;

import yaka.Constante;
import yaka.Yaka;
import concept.ident.IdConst;
import concept.ident.Ident;

public abstract class OperateurUnaire extends Operateur {

	@Override
	public void consume(Stack<Ident> pileValeur) {
		// l'élément que l'on va étudier est le dernier sur la pile
		Ident id = pileValeur.pop();
		if(id.getType() == Constante.ERREUR) {
			// on se contente de propager l'erreur
			pileValeur.add(new IdConst(Constante.ERREUR));
		}
		else if(!this.accepteType(id.getType())) {
			// c'est une nouvelle erreur de type
			Yaka.em.expression.mauvaisTypeUnaire(this, id);
			pileValeur.add(new IdConst(Constante.ERREUR));
		}
		else {
			// les opérateurs unaires ne changent pas le type : on ré-empile donc l'ancienne Ident
			pileValeur.add(new IdConst(this.typeResultat()));
		}
	}

}
