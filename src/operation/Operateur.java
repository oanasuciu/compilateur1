package operation;

import java.util.Stack;

import yaka.Ident;

public abstract class Operateur {
	/**
	 * Renvoie le texte utilisé dans la YVM selon le type de l'opération (plus/moins/div/...)
	 * 
	 * @return le texte correspondant à l'opération
	 */
	abstract public String getYVMText();
	
	/**
	 * Indique si un type est accepté par un opérateur
	 * 
	 * @param typeATester le type dont il faut vérifier l'acceptation
	 * 
	 * @return vrai si le type est autorisé avec cet opérateur, faux sinon
	 */
	abstract public boolean accepteType(int typeATester);
	
	/**
	 * Renvoie le type du résultat de l'opération
	 * 
	 * @return le type du résultat de l'opération
	 */
	abstract public int typeResultat();

	@Override
	public String toString() {
		return "Operation";
	}

	abstract public void consume(Stack<Ident> pileValeur);
}