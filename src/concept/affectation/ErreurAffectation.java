package concept.affectation;

import concept.ident.Ident;
import erreur.ErreurManager;
import utils.Ecriture;

public class ErreurAffectation {
	private ErreurManager em;

	public ErreurAffectation(ErreurManager em) {
		this.em = em;
	}

	public void ecraseIdentificateur(String ident) {
		this.em.ecritInfoBase(true);
		System.out.println("WARNING: L'identificateur \"" + ident + "\" a été re-déclaré.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "WARNING: L'identificateur \"" + ident + "\" a été re-déclaré.");
	}

	public void aucuneValeurAAffecter() {
		this.em.ecritInfoBase(false);
		System.out.println("Aucune valeur trouvée pour l'affectation.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Aucune valeur trouvée pour l'affectation.");
	}

	public void mauvaisTypeAffectation(Ident id1, Ident id2) {
		this.em.ecritInfoBase(false);
		System.out.println("Affectation non définie entre ces types :");
		System.out.println("         Affectation dans la variable : " + id1.getNom() + " de type " + id1.getType().getNom());
		System.out.println("         Depuis le type " + id2.getType().getNom());
		Ecriture.ecrireStringln(this.em.fichierErreur, "Affectation non définie entre ces types :");
		Ecriture.ecrireStringln(this.em.fichierErreur, "         Affectation dans la variable : " + id1.getNom() + " de type " + id1.getType().getNom());
		Ecriture.ecrireStringln(this.em.fichierErreur, "         Depuis le type " + id2.getType().getNom());
	}

	public void affectationIllegale(Ident id) {
		this.em.ecritInfoBase(false);
		System.out.println("Tentative d'affectation dans une "+id.getTypeIdent()+" (" + id.getNom() + ").");
		Ecriture.ecrireStringln(this.em.fichierErreur, "Tentative d'affectation dans une "+id.getTypeIdent()+" (" + id.getNom() + ").");
	}

}
