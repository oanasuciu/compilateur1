package generation;

import java.io.File;
import java.io.OutputStream;

import concept.expression.operation.Operateur;
import concept.ident.Ident;
import utils.Ecriture;
import yaka.Yaka;

public class YVM {
	protected String nomFichier;
	protected OutputStream ficYVM;
	protected boolean interactif;
	protected static int[] numerotationIteration;
	protected static int profondeurIteration = 0;

	public YVM(String nomFichier, boolean interactif) {
		this.nomFichier = nomFichier;
		this.interactif = interactif;
		System.out.println(this.nomFichier + this.getExtension());
		ficYVM = Ecriture.ouvrir(this.nomFichier + this.getExtension());
		numerotationIteration = new int[10];
	}
	
	public String getExtension() {
		return ".yvm";
	}

	/*
	 * Méthodes "visiteur" pour les opérations et les identificateurs
	 */

	public void operation(Operateur op) {
		op.visiteYVM(this);
	}

	public void ident(Ident id) {
		id.visiteYVM(this);
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

	public void ouvrePrinc(int nbVar) {
		Ecriture.ecrireStringln(ficYVM, "ouvrePrinc " + nbVar);
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
	
	public String stringNumerotation(){
		String res = "";
		if (profondeurIteration<=1){
			res+=numerotationIteration[profondeurIteration-1];
		}else {
			for(int i=0;i<profondeurIteration-1;i++) res+=numerotationIteration[i]+".";
			res+=numerotationIteration[profondeurIteration-1];
		}
		return res;
	}
	
	public void tantque(){
		numerotationIteration[profondeurIteration]++;
		profondeurIteration++;
		Ecriture.ecrireStringln(ficYVM, "\nFAIRE"+stringNumerotation()+":");
	}
	
	public void faire(){
		Ecriture.ecrireStringln(ficYVM, "iffaux FAIT"+stringNumerotation());
	}
	
	public void fait(){
		Ecriture.ecrireStringln(ficYVM, "goto FAIRE"+stringNumerotation()+"\nFAIT"+stringNumerotation()+":\n");
		numerotationIteration[profondeurIteration--]=0;
	}
}
