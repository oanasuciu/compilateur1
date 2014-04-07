package concept.es;

import utils.Ecriture;
import concept.ident.Ident;
import erreur.ErreurManager;

public class ErreurES {
	private ErreurManager em;

	public ErreurES(ErreurManager em) {
		this.em = em;
	}

	public void aucuneValeurAEcrire() {
		this.em.ecritInfoBase(false);
		System.out.println("Aucune valeur à écrire.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Aucune valeur à écrire.");
	}

	public void lireEntierSurNonEntier(Ident id) {
		this.em.ecritInfoBase(false);
		System.out.println("Appel de LIRE sur une variable de type différent d'entier.");
		System.out.println("         Variable "+id.getNom()+" de type "+id.getType().getNom());
		Ecriture.ecrireStringln(this.em.fichierErreur, "Appel de LIRE sur une variable de type différent d'entier.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "         Variable "+id.getNom()+" de type "+id.getType().getNom());
	}
}
