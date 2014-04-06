package concept.expression;

import java.util.ArrayList;
import java.util.Stack;

import yaka.Constante;
import yaka.Yaka;
import concept.expression.operation.Operateur;
import concept.ident.IdConst;
import concept.ident.IdVar;
import concept.ident.Ident;

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
	/**
	 * Pile des paramètres.
	 * Utilisé lors de l'appel de fonctions
	 */
	Stack<ArrayList<IdVar>> pileParams;
	/**
	 * Pile du nombre de paramètres ayant déjà été vérifiées.
	 * Utilisé lors de l'appel de fonctions
	 * Utilisation d'une pile car les appels de fonctions peuvent être imbriqués
	 * 
	 * Valeurs spéciales :
	 * -1 : on tente d'appeler une ident qui n'est pas une fonction comme une fonction, ou l'ident n'existe pas
	 */
	Stack<Integer> pileNbParams;

	public Expression() {
		this.pileOperation = new Stack<Operateur>();
		this.pileValeur = new Stack<Ident>();
		this.pileParams = new Stack<ArrayList<IdVar>>();
		this.pileNbParams = new Stack<Integer>();
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
		IdConst cst = new IdConst(Constante.BOOLEEN);
		cst.setValeur(b);
		pileValeur.add(cst);
		cst.chargeValeur();
	}
	
	public void ajouteValeur(int nb) {
		IdConst cst = new IdConst(Constante.ENTIER);
		cst.setValeur(nb);
		pileValeur.add(cst);
		cst.chargeValeur();
	}

	public void ajouteOperation(Operateur op) {
		pileOperation.add(op);
	}

	public void faireOperation() {
		Operateur op = pileOperation.pop();
		op.consume(pileValeur);
		Yaka.yvm.operation(op);
	}
	
	public void appelleFonctionDebut() {
		Ident fonction = this.pileValeur.peek();
		if(fonction.getType() == Constante.ERREUR) {
			// l'Ident n'existe pas : l'erreur a déjà été gérée
			this.pileParams.add(new ArrayList<IdVar>());
			this.pileNbParams.add(-1);
			return;
		}
		ArrayList<IdVar> params = fonction.getParams();
		if(params == null) {
			Yaka.em.fonction.identEstPasUneFonction(fonction);
			this.pileParams.add(new ArrayList<IdVar>());
			this.pileNbParams.add(-1);
			return;
		}
		this.pileParams.add(params);
		this.pileNbParams.add(0);
	}
	
	public void appelleFonctionParam() {
		int paramIndex = this.pileNbParams.pop();
		if(paramIndex == -1) {
			// on est dans un cas d'erreur qui a déjà été traité, on ne fait rien d'autre !
			this.pileNbParams.push(paramIndex);
			return;
		}
		ArrayList<IdVar> params = this.pileParams.peek();
		if(paramIndex >= params.size()) {
			// on est dans le cas d'un surplus d'argument : on continue d'augmenter le nombre de paramètres vérifiés,
			// afin de donner un compte précis d'arguments donnés vs attendus à la fin de l'appel
			this.pileNbParams.push(++paramIndex);
			return;
		}
		Ident identFournie = Yaka.expression.recupereTete();
		Ident identAttendue = params.get(paramIndex);
		if(identFournie.getType() != Constante.ERREUR && identFournie.getType() != identAttendue.getType()) {
			Yaka.em.fonction.typeParamInvalide(identAttendue, identFournie);
		}
		this.pileNbParams.push(++paramIndex);
	}
	
	public void appelleFonctionFin() {
		int paramVerifie = this.pileNbParams.pop();
		ArrayList<IdVar> params = this.pileParams.pop();
		if(params.size() != paramVerifie) {
			Yaka.em.fonction.nbParamInvalide(params.size(), paramVerifie);
		}
		Ident fonction = this.pileValeur.peek();
		Yaka.yvm.call(fonction.getNom());
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