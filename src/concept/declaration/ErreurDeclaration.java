package concept.declaration;

import concept.ident.Ident;
import erreur.ErreurManager;
import utils.Ecriture;

public class ErreurDeclaration {
	private ErreurManager em;

	public ErreurDeclaration(ErreurManager em) {
		this.em = em;
	}

	public void ecraseFonction(String fonc) {
		this.em.ecritInfoBase(true);
		System.out.println("WARNING: La fonction \"" + fonc + "\" a été re-déclaré.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "WARNING: La fonciton \"" + fonc + "\" a été re-déclaré.");
	}

	public void mauvaiseDeclarationConstante(String partieGauche, Ident partieDroite) {
		this.em.ecritInfoBase(false);
		System.out.println("Seules les constantes peuvent être utilisées en partie droite lors de la déclaration de constante.");
		System.out.println("         Affectation dans la constante : " + partieGauche);
		System.out.println("         Depuis l'identificateur "+partieDroite.getNom()+" de type " + partieDroite.getTypeIdent());
		Ecriture.ecrireStringln(this.em.fichierErreur, "Seules les constantes peuvent être utilisées en partie droite lors de la déclaration de constante.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "         Affectation dans la constante : " + partieGauche);
		Ecriture.ecrireStringln(this.em.fichierErreur, "         Depuis l'identificateur "+partieDroite.getNom()+" de type " + partieDroite.getTypeIdent());
	}
}
