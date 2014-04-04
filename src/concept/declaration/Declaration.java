package concept.declaration;

import concept.ident.IdVar;
import concept.ident.Ident;
import concept.ident.IdConst;
import type.Type;
import yaka.Constante;
import yaka.Yaka;

public class Declaration {
	/**
	 * Le dernier type lu dans la grammaire
	 */
	private Type typeCourant;
	private Ident identCourante;

	/**
	 * Déclaration d'une nouvelle variable
	 * 
	 * @param nom
	 *            Nom de la variable
	 */
	public void nouvelleVariable(String nom) {
		Ident id = new IdVar(nom, this.typeCourant);
		Yaka.tabIdent.rangeIdent(nom, id);
	}

	/**
	 * 
	 * @param nom
	 * @param valeur
	 */
	public void nouvelleConstante(String nom) {
		Ident id = new IdConst(nom);
		Yaka.tabIdent.rangeIdent(nom, id);
		this.identCourante = id;
	}

	/**
	 * Met à jour le dernier type lu dans la grammaire
	 * 
	 * @param type
	 *            Une constante représentant le type (entier ou booléen)
	 */
	public void majType(Type type) {
		this.typeCourant = type;
	}

	/**
	 * Met à jour la valeur de l'Ident courante
	 * 
	 * @param valeur la nouvelle valeur
	 */
	public void majValeur(int valeur) {
		this.identCourante.setType(Constante.ENTIER);
		this.identCourante.setValeur(valeur);
	}
	
	/**
	 * Met à jour la valeur de l'Ident courante
	 * 
	 * @param valeur la nouvelle valeur
	 */
	public void majValeur(boolean valeur) {
		this.identCourante.setType(Constante.BOOLEEN);
		this.identCourante.setValeur(valeur);
	}
	
	/**
	 * Met à jour la valeur de l'Ident courante
	 * 
	 * @param ident l'identificateur de l'ident dont il faut prendre la valeur
	 */
	public void majValeur(String ident) {
		Ident id = Yaka.tabIdent.chercheIdent(ident);
		if(id == null) {
			Yaka.em.identificateurInexistant(ident);
			this.identCourante.setType(Constante.ERREUR);
			return;
		}
		this.identCourante.setType(id.type);
		this.identCourante.setValeur(id.valeur);
	}
	
	public Type getTypeCourant() {
		return this.typeCourant;
	}
}