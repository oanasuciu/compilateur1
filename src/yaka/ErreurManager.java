package yaka;

import operation.Operateur;

public class ErreurManager {
	private boolean hasErreur = false;

	public int getNumLigne() {
		return SimpleCharStream.getBeginLine();
	}
	
	public boolean hasErreur() {
		return this.hasErreur;
	}
	
	/**
	 * Cette fonction écrit les informations d'environnement lors d'une erreur (pour l'instant, juste le numéro de ligne)
	 */
	public void ecritInfoBase() {
		hasErreur = true;
		System.out.print("Ligne " + this.getNumLigne() + " : ");
	}

	public void identificateurInexistant(String ident) {
		this.ecritInfoBase();
		System.out.println("Identificateur \"" + ident + "\" inexistant.");
	}

	public void mauvaisType(Operateur op, Ident id1, Ident id2) {
		this.ecritInfoBase();
		System.out.println("Opération " + op + " entre " + id1.getType().getNom() + " et " + id2.getType().getNom() + " non définie.");
	}

	public void mauvaisType(Operateur op, Ident id) {
		this.ecritInfoBase();
		System.out.println("Opération " + op + " avec " + id.getType().getNom() + " non définie.");
	}
}