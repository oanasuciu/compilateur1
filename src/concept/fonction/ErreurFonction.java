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
