package concept.expression;

import concept.expression.operation.Operateur;
import concept.ident.IdConst;

import java.util.Stack;

import concept.ident.Ident;
import yaka.Constante;
import yaka.Yaka;

public class Expression {
	/**
	 * Pile des opérations.
	 * Chaque opération est représentée par une constante => type int
	 */
	Stack<Operateur> pileOperation;
	/**
	 * Pile des valeurs.
	 * Au final, une valeur est soit une variable, soit une constante => type Ident
	 */
	Stack<Ident> pileValeur;

	public Expression() {
		pileOperation = new Stack<Operateur>();
		pileValeur = new Stack<Ident>();
	}

	public void ajouteValeur(String ident) {
		Ident id = Yaka.tabIdent.chercheIdent(ident);
		if(id == null) {
			// identificateur inexistant : gestion de l'erreur
			Yaka.em.identificateurInexistant(ident);
			id = new IdConst(Constante.ERREUR);
		}
		pileValeur.add(id);
		Yaka.yvm.ident(id);
	}
	
	public void ajouteValeur(boolean b) {
		Ident cst = new IdConst(Constante.BOOLEEN);
		cst.setValeur(b);
		pileValeur.add(cst);
		Yaka.yvm.iconst(cst.getValeur());
	}
	
	public void ajouteValeur(int nb) {
		Ident cst = new IdConst(Constante.ENTIER);
		cst.setValeur(nb);
		pileValeur.add(cst);
		Yaka.yvm.iconst(cst.getValeur());
	}

	public void ajouteOperation(Operateur op) {
		pileOperation.add(op);
	}

	public void faireOperation() {
		Operateur op = pileOperation.pop();
		op.consume(pileValeur);
		Yaka.yvm.operation(op);
	}
	
	/**
	 * Renvoie la tête de la pile des valeurs, ou null si aucune trouvée
	 * 
	 * @return l'Ident
	 */
	public Ident recupereTete() {
		if(this.pileValeur.size() > 0)
			return this.pileValeur.pop();
		else
			return null;
	}
}