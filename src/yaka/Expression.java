package yaka;

import java.util.Stack;

import operation.Operateur;

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
		System.out.println(id.getYVMText()+" "+id.getValeur());
	}
	
	public void ajouteValeur(boolean b) {
		Ident cst = new IdConst(Constante.BOOLEEN);
		cst.setValeur(b);
		pileValeur.add(cst);
		System.out.println("iconst "+cst.getValeur());
	}
	
	public void ajouteValeur(int nb) {
		Ident cst = new IdConst(Constante.ENTIER);
		cst.setValeur(nb);
		pileValeur.add(cst);
		System.out.println("iconst "+nb);
	}

	public void ajouteOperation(Operateur op) {
		pileOperation.add(op);
	}

	public void faireOperation() {
		Operateur op = pileOperation.pop();
		op.consume(pileValeur);
		System.out.println(op.getYVMText());
	}
}