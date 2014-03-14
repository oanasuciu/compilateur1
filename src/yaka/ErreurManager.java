package yaka;

import java.io.OutputStream;

import utils.Ecriture;
import concept.expression.operation.Operateur;
import concept.ident.Ident;

public class ErreurManager {
	private boolean hasErreur = false;
	public static OutputStream fichierErreurs = Ecriture.ouvrir("errorLog.txt");

	public int getNumLigne() {
		return SimpleCharStream.getBeginLine();
	}

	public boolean hasErreur() {
		return this.hasErreur;
	}

	/**
	 * Cette fonction écrit les informations d'environnement lors d'une erreur
	 * (pour l'instant, juste le numéro de ligne)
	 */
	public void ecritInfoBase(boolean isWarning) {
		if(!isWarning)
			hasErreur = true;
		System.out.print("Ligne " + this.getNumLigne() + " : ");
	}

	public void ecraseIdentificateur(String ident) {
		this.ecritInfoBase(true);
		System.out.println("WARNING: L'identificateur \"" + ident + "\" a été re-déclaré.");
		Ecriture.ecrireStringln(fichierErreurs, "WARNING: L'identificateur \"" + ident + "\" a été re-déclaré.");
	}

	public void identificateurInexistant(String ident) {
		this.ecritInfoBase(false);
		System.out.println("Identificateur \"" + ident + "\" inexistant.");
		Ecriture.ecrireStringln(fichierErreurs, "Identificateur \"" + ident + "\" inexistant.");
	}

	public void aucuneValeurAAffecter() {
		this.ecritInfoBase(false);
		System.out.println("Aucune valeur trouvée pour l'affectation.");
		Ecriture.ecrireStringln(fichierErreurs, "Aucune valeur trouvée pour l'affectation.");
	}

	public void aucuneValeurAEcrire() {
		this.ecritInfoBase(false);
		System.out.println("Aucune valeur à écrire.");
	}

	public void mauvaisType(Operateur op, Ident id1, Ident id2) {
		this.ecritInfoBase(false);
		String membreGauche;
		if(id1.isVar()) {
			membreGauche = id1.getNom();
		}
		else {
			membreGauche = "constante";
		}
		String membreDroit;
		if(id2.isVar()) {
			membreDroit = id2.getNom();
		}
		else {
			membreDroit = "constante";
		}
		System.out.println("Opération " + op + " non définie avec ces types :");
		System.out.println("         Membre gauche : "+membreGauche+" de type " + id1.getType().getNom());
		System.out.println("         Membre droit : "+membreDroit+" de type " + id2.getType().getNom());
	}

	public void mauvaisType(Operateur op, Ident id) {
		this.ecritInfoBase(false);
		String operande;
		if(id.isVar()) {
			operande = id.getNom();
		}
		else {
			operande = "constante";
		}
		System.out.println("Opération " + op + " non définie avec ce type :");
		System.out.println("         Opérande : "+operande+" de type " + id.getType().getNom());
	}

	public void mauvaisTypeAffectation(Ident id1, Ident id2) {
		this.ecritInfoBase(false);
		System.out.println("Affectation non définie entre ces types :");
		System.out.println("         Affectation dans la variable : " + id1.getNom() + " de type " + id1.getType().getNom());
		System.out.println("         Depuis le type " + id2.getType().getNom());
	}

	public void affectationDansConstante(Ident id) {
		this.ecritInfoBase(false);
		System.out.println("Tentative d'affectation dans une constante (" + id.getNom() + ").");
	}

	public void stockerErreurs() {
		if (hasErreur)
			;
	}
}