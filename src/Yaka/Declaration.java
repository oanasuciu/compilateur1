package Yaka;

public class Declaration {
	/**
	 * Le dernier type lu dans la grammaire
	 */
	private int typeCourant;
	private Ident constanteCourante;
	
	public Declaration() {
		
	}
	
	/**
	 * Met à jour le dernier type lu dans la grammaire
	 * 
	 * @param type Une constante représentant le type (entier ou booléen)
	 */
	public void metAJourType(int type) {
		this.typeCourant = type;
	}
	
	/**
	 * Déclaration d'une nouvelle variable
	 * 
	 * @param nom Nom de la variable
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
		this.constanteCourante = id;
	}
	
	public void majConstante(int valeur) {
		//this.constanteCourante.
	}
}