package yaka;

import java.util.Stack;

import operation.Operation;

public class Expression {
	/**
	 * Pile des opérations.
	 * Chaque opération est représentée par une constante => type int
	 */
	Stack<Operation> pileOperation;
	/**
	 * Pile des valeurs.
	 * Au final, une valeur est soit une variable, soit une constante => type Ident
	 */
	Stack<Ident> pileValeur;

	public Expression() {
		pileOperation = new Stack<Operation>();
		pileValeur = new Stack<Ident>();
	}

	public void ajouteValeur(String ident) {
		Ident id = Yaka.tabIdent.chercheIdent(ident);
		if(id == null) {
			// TODO: gestion erreur identificateur inexistant
			return;
		}
		pileValeur.add(id);
		System.out.println(id.getYVMText()+" "+id.getValeur());
	}
	
	public void ajouteValeur(boolean b) {
		Ident cst = new IdConst(Yaka.constante.BOOLEEN);
		cst.setValeur(b);
		pileValeur.add(cst);
		System.out.println("iconst "+cst.getValeur());
	}
	
	public void ajouteValeur(int nb) {
		Ident cst = new IdConst(Yaka.constante.ENTIER);
		cst.setValeur(nb);
		pileValeur.add(cst);
		System.out.println("iconst "+nb);
	}

	public void ajouteOperation(Operation op) {
		pileOperation.add(op);
	}

	public void faireOperation() {
		System.out.println(pileOperation);
		Operation op = pileOperation.pop();
		pileValeur.pop();
		System.out.println(op.getYVMText());
		/*if(op != Yaka.constante.MOINS) {
			pileValeur.pop();
			pileValeur.add("ignore");/
		}*
		/*switch (op) {
			case '-':
				Ecriture.ecrireStringln(flot, "isub");
				break;
			case '+':
				Ecriture.ecrireStringln(flot, "iadd");
				break;
			case '*':
				Ecriture.ecrireStringln(flot, "imul");
				break;
			case '/':
				Ecriture.ecrireStringln(flot, "idiv");
				break;
		}*/
	}
}