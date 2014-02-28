package operation;

import java.util.Stack;

import type.Type;
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
	abstract public boolean accepteType(Type typeATester);
	
	/**
	 * Renvoie le type du résultat de l'opération
	 * 
	 * @return le type du résultat de l'opération
	 */
	abstract public Type typeResultat();

	@Override
	public String toString() {
		return "Operation";
	}
	
	/**
	 * A partir de la pile, fait l'opération liée à l'opérateur.
	 * Par exemple, pour une addition, dépile les deux derniers éléments et ré-empile le résultat (sans vraiment faire le calcul)
	 * 
	 * @param pileValeur
	 * 	La pile des valeurs utilisé pour éxécuter l'opération.
	 */
	abstract public void consume(Stack<Ident> pileValeur);
}