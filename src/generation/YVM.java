package generation;

import java.io.File;
import java.io.OutputStream;

import utils.Ecriture;
import yaka.Yaka;
import concept.expression.operation.Operateur;
import concept.ident.Ident;

public class YVM {
	protected String nomFichier;
	protected OutputStream ficYVM;
	protected boolean interactif;

	public YVM(String nomFichier, boolean interactif) {
		this.nomFichier = nomFichier;
		this.interactif = interactif;
		System.out.println(this.nomFichier + this.getExtension());
		ficYVM = Ecriture.ouvrir(this.nomFichier + this.getExtension());
	}
	
	public String getExtension() {
		return ".yvm";
	}

	/*
	 * Méthodes "visiteur" pour les opérations et les identificateurs
	 */

	public void operation(Operateur op) {
		op.faitOperation();
	}

	public void ident(Ident id) {
		id.chargeValeur();
	}

	/*
	 * Les meta-instructions (entete, queue)
	 */

	public void entete() {
		Ecriture.ecrireStringln(ficYVM, "entete");
	}

	public void queue() {
		Ecriture.ecrireStringln(ficYVM, "queue");
		// c'est le dernier élément : on ferme le descripteur du fichier
		Ecriture.fermer(ficYVM);
		// s'il y a eu une erreur de compilation, on efface le fichier :
		// on ne laisse pas l'utilisateur utiliser un tel fichier qui est
		// incomplet sur plusieurs points
		if (Yaka.em.hasErreur()) {
			File f = new File(this.nomFichier + this.getExtension());
			f.delete();
		}
	}

	/*
	 * Les instructions pour les fonctions
	 */

	public void ouvrePrinc() {
		Ecriture.ecrireStringln(ficYVM, "main:");
	}
	
	public void ouvreBloc(int val) {
		Ecriture.ecrireStringln(ficYVM, "ouvreBloc "+val);
	}
	
	public void fermeBloc(int val) {
		Ecriture.ecrireStringln(ficYVM, "fermeBloc "+val);
	}
	
	public void ireturn(int val) {
		Ecriture.ecrireStringln(ficYVM, "ireturn "+val);
	}
	
	public void reserveRetour() {
		Ecriture.ecrireStringln(ficYVM, "reserveRetour");
	}
	
	public void call(String nomFonction) {
		Ecriture.ecrireStringln(ficYVM, "call "+nomFonction);
	}

	/*
	 * Les instructions d'entrée/sortie
	 */

	public void lireEnt(int offset) {
		Ecriture.ecrireStringln(ficYVM, "lireEnt " + offset);
	}

	public void ecrireBool() {
		Ecriture.ecrireStringln(ficYVM, "ecrireBool");
	}

	public void ecrireChaine(String str) {
		Ecriture.ecrireStringln(ficYVM, "ecrireChaine " + str + "");
	}

	public void ecrireEnt() {
		Ecriture.ecrireStringln(ficYVM, "ecrireEnt");
	}

	public void aLaLigne() {
		Ecriture.ecrireStringln(ficYVM, "aLaLigne");
	}

	/*
	 * Les instructions pour les affectations et les expressions
	 */

	public void iconst(int val) {
		Ecriture.ecrireStringln(ficYVM, "iconst " + val);
	}

	public void iload(int val) {
		Ecriture.ecrireStringln(ficYVM, "iload " + val);
	}

	public void istore(int val) {
		Ecriture.ecrireStringln(ficYVM, "istore " + val);
	}

	/*
	 * Les instructions pour les opérations
	 */

	public void iadd() {
		Ecriture.ecrireStringln(ficYVM, "iadd");
	}

	public void iand() {
		Ecriture.ecrireStringln(ficYVM, "iand");
	}

	public void idiff() {
		Ecriture.ecrireStringln(ficYVM, "idiff");
	}

	public void idiv() {
		Ecriture.ecrireStringln(ficYVM, "idiv");
	}

	public void iegal() {
		Ecriture.ecrireStringln(ficYVM, "iegal");
	}

	public void iinf() {
		Ecriture.ecrireStringln(ficYVM, "iinf");
	}

	public void iinfegal() {
		Ecriture.ecrireStringln(ficYVM, "iinfegal");
	}

	public void ineg() {
		Ecriture.ecrireStringln(ficYVM, "ineg");
	}

	public void imul() {
		Ecriture.ecrireStringln(ficYVM, "imul");
	}

	public void inot() {
		Ecriture.ecrireStringln(ficYVM, "inot");
	}

	public void ior() {
		Ecriture.ecrireStringln(ficYVM, "ior");
	}

	public void isub() {
		Ecriture.ecrireStringln(ficYVM, "isub");
	}

	public void isup() {
		Ecriture.ecrireStringln(ficYVM, "isup");
	}

	public void isupegal() {
		Ecriture.ecrireStringln(ficYVM, "isupegal");
	}
	
	public void iffaux(String etiquette) {
		Ecriture.ecrireStringln(ficYVM, "iffaux "+etiquette);
	}

	public void goTo(String etiquette) {
		Ecriture.ecrireStringln(ficYVM, "goto "+etiquette);
	}

	public void etiquette(String etiquette) {
		Ecriture.ecrireStringln(ficYVM, etiquette+":");
	}
}
