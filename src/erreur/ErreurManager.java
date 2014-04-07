package erreur;

import java.io.OutputStream;

import utils.Ecriture;
import yaka.SimpleCharStream;
import concept.affectation.ErreurAffectation;
import concept.controle.ErreurStructureControle;
import concept.declaration.ErreurDeclaration;
import concept.es.ErreurES;
import concept.expression.ErreurExpression;
import concept.fonction.ErreurFonction;

public class ErreurManager {
	public OutputStream fichierErreur;
	public ErreurAffectation affectation;
	public ErreurDeclaration declaration;
	public ErreurExpression expression;
	public ErreurStructureControle structureControle;
	public ErreurES es;
	public ErreurFonction fonction;
	private boolean hasErreur = false;

	public ErreurManager(String nomFichier) {
		this.fichierErreur = Ecriture.ouvrir(nomFichier+".err");
		this.affectation = new ErreurAffectation(this);
		this.declaration = new ErreurDeclaration(this);
		this.expression = new ErreurExpression(this);
		this.structureControle = new ErreurStructureControle(this);
		this.es = new ErreurES(this);
		this.fonction = new ErreurFonction(this);
	}

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
		Ecriture.ecrireString(this.fichierErreur, "Ligne " + this.getNumLigne() + " : ");
	}

	public void identificateurInexistant(String ident) {
		this.ecritInfoBase(false);
		System.out.println("Identificateur \"" + ident + "\" inexistant.");
		Ecriture.ecrireStringln(this.fichierErreur, "Identificateur \"" + ident + "\" inexistant.");
	}
	
}