package concept.fonction;

import utils.Ecriture;
import concept.ident.Ident;
import erreur.ErreurManager;

public class ErreurFonction {
	private ErreurManager em;

	public ErreurFonction(ErreurManager em) {
		this.em = em;
	}
	
	public void fonctionInexistante(String fonc) {
		this.em.ecritInfoBase(false);
		System.out.println("Fonction \"" + fonc + "\" inexistante.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Fonction \"" + fonc + "\" inexistante.");
	}
	
	/*
	 * Erreur appelée à chaque paramètre invalide lors de l'appelle d'une fonction
	 * 
	 */
	public void typeParamInvalide(Ident identFonction, Ident paramAttendu, Ident paramFourni) {
		this.em.ecritInfoBase(false);
		System.out.println("Type de paramètre de fonction invalide.");
		System.out.println("La fonction "+identFonction.getNom()+" doit recevoir un paramètre de type : "+paramAttendu.getType().getNom());
		System.out.println("Le type de "+ paramFourni.getNom() + " (" + paramFourni.getType().getNom() + ") ne correspond pas.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Type de paramètre de fonction invalide.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "La fonction doit recevoir un paramètre de type : "+paramAttendu.getType().getNom());
		Ecriture.ecrireStringln(this.em.fichierErreur, "Le type de "+ paramFourni.getNom() + " (" + paramFourni.getType().getNom() + ") ne correspond pas.");
	}

	public void retourInvalide(Ident identAttendu, Ident identFourni) {
		this.em.ecritInfoBase(false);
		System.out.println("Retour de fonction invalide \""+identAttendu.getNom()+"\".");
		System.out.println("La retour de la fonction "+identAttendu.getNom()+" est de type "+identAttendu.getType().getNom()+".");
		System.out.println("Un retour de type "+ identFourni.getType().getNom() +" a été reçu.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Retour de fonction invalide");
		Ecriture.ecrireStringln(this.em.fichierErreur, "La retour de la fonction "+identAttendu.getNom()+" est de type "+identAttendu.getType().getNom()+".");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Un retour de type "+ identFourni.getType().getNom() +" a été reçu.");
	}

	public void nbParamInvalide(Ident identFonction, int paramVerifie) {
		this.em.ecritInfoBase(false);
		System.out.println("Nombre de paramètres de fonction invalide pour la fonction \"" + identFonction.getNom() + "\".");
		System.out.println("Nombre de paramètres attendus : " + identFonction.getParams().size() + ".");
		System.out.println("Nombre de paramètres donnés : " + paramVerifie+".");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Nombre de paramètres de fonction invalide pour la fonction \"" + identFonction.getNom() + "\".");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Nombre de paramètres attendus : " + identFonction.getParams().size() + ".");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Nombre de paramètres donnés : " + paramVerifie+".");
	}

	public void identEstPasUneFonction(Ident id) {
		this.em.ecritInfoBase(false);
		System.out.println("Utilisation de l'identificateur \"" + id.getNom() + "\" comme une fonction, alors que c'est une "+id.getTypeIdent()+".");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Utilisation de l'identificateur \"" + id.getNom() + "\" comme une fonction, alors que c'est une "+id.getTypeIdent()+".");
	}
	
	public void retourDansMain(){
		this.em.ecritInfoBase(false);
		System.out.println("Instruction RETOURNE dans le main interdite.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Instruction RETOURNE dans le main interdite.");
	}

}
