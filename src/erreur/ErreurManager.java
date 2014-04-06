package erreur;

import java.io.OutputStream;

import utils.Ecriture;
import yaka.SimpleCharStream;
import concept.affectation.ErreurAffectation;
import concept.declaration.ErreurDeclaration;
import concept.expression.operation.Operateur;
import concept.ident.Ident;

public class ErreurManager {
	public OutputStream fichierErreur;
	public ErreurAffectation affectation;
	public ErreurDeclaration declaration;
	private boolean hasErreur = false;

	public ErreurManager(String nomFichier) {
		this.fichierErreur = Ecriture.ouvrir(nomFichier+".err");
		this.affectation = new ErreurAffectation(this);
		this.declaration = new ErreurDeclaration(this);
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

	public void aucuneValeurAEcrire() {
		this.ecritInfoBase(false);
		System.out.println("Aucune valeur à écrire.");
		Ecriture.ecrireStringln(this.fichierErreur, "Aucune valeur à écrire.");
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
		Ecriture.ecrireStringln(this.fichierErreur, "Opération " + op + " non définie avec ces types :");
		Ecriture.ecrireStringln(this.fichierErreur, "         Membre gauche : "+membreGauche+" de type " + id1.getType().getNom());
		Ecriture.ecrireStringln(this.fichierErreur, "         Membre droit : "+membreDroit+" de type " + id2.getType().getNom());
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
		Ecriture.ecrireStringln(this.fichierErreur, "Opération " + op + " non définie avec ce type :");
		Ecriture.ecrireStringln(this.fichierErreur, "         Opérande : "+operande+" de type " + id.getType().getNom());
	}
	
	public void expressionNonBooleen(Ident id){
		this.ecritInfoBase(false);
		String expr;
		if(id.isVar()) {
			expr = id.getNom();
		}
		else {
			expr = "constante";
		}
		System.out.println("L'expression pour l'itération n'est pas booléenne.");
		System.out.println("         Expression : "+expr+" de type " + id.getType().getNom());
		Ecriture.ecrireStringln(this.fichierErreur, "L'expression pour l'itération n'est pas booléenne.");
		Ecriture.ecrireStringln(this.fichierErreur, "         Expression : "+expr+" de type " + id.getType().getNom());
	}
	
	public void fonctionInexistante(String fonc) {
		this.ecritInfoBase(false);
		System.out.println("Fonction \"" + fonc + "\" inexistante.");
		Ecriture.ecrireStringln(this.fichierErreur, "Fonction \"" + fonc + "\" inexistante.");
	}
	
	public void typeParamInvalide(Ident identAttendue, Ident id) {
		System.out.println("typeParamInvalide");
		// TODO
		/*this.ecritInfoBase(false);
		System.out.println("La fonction doit recevoir des paramètre de type : ");
		Ecriture.ecrireStringln(this.fichierErreur, "La fonction doit recevoir des paramètre de type : ");
		for(Ident t : identAttendue.getParams()){System.out.println(t.getType() +" ");Ecriture.ecrireStringln(this.fichierErreur,t +" ");}
		System.out.println("Le type de "+ id.getNom() + "("+ id.getType() + ") ne correspond pas.");
		Ecriture.ecrireStringln(this.fichierErreur, "Le type de "+ id.getNom() + "("+ id.getType() + ") ne correspond pas.");*/
	}

	public void lireEntierSurNonEntier(Ident id) {
		this.ecritInfoBase(false);
		System.out.println("Appel de LIRE sur une variable de type différent d'entier.");
		System.out.println("         Variable "+id.getNom()+" de type "+id.getType().getNom());
		Ecriture.ecrireStringln(this.fichierErreur, "Appel de LIRE sur une variable de type différent d'entier.");
		Ecriture.ecrireStringln(this.fichierErreur, "         Variable "+id.getNom()+" de type "+id.getType().getNom());
	}

	public void retourInvalide(Ident identAttendue, Ident identFournie) {
		System.out.println("retourInvalide");
		// TODO Auto-generated method stub
		
	}

	public void nbParamInvalide(int size, int paramVerifie) {
		System.out.println("nbParamInvalide");
		// TODO Auto-generated method stub
		/*this.ecritInfoBase(false);
		System.out.println("Nombre de paramètres invalide pour la fonction " + fonc.getNom() + ".");
		System.out.println("La fonction " + fonc.getNom() + " a besoin de " + fonc.getParams().size() + "paramètres.");
		Ecriture.ecrireStringln(this.fichierErreur, "Nombre de paramètres invalide pour la fonction " + fonc.getNom() + ".");
		Ecriture.ecrireStringln(this.fichierErreur, "La fonction " + fonc.getNom() + " a besoin de " + fonc.getParams().size() + "paramètres.");*/
	}

	public void identEstPasUneFonction(Ident fonction) {
		System.out.println("identEstPasUneFonction");
		// TODO Auto-generated method stub
		
	}
}