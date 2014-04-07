package concept.expression;

import utils.Ecriture;
import concept.expression.operation.Operateur;
import concept.ident.Ident;
import erreur.ErreurManager;

public class ErreurExpression {
	private ErreurManager em;

	public ErreurExpression(ErreurManager em) {
		this.em = em;
	}
	
	public void mauvaisTypeBinaire(Operateur op, Ident id1, Ident id2) {
		this.em.ecritInfoBase(false);
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
		Ecriture.ecrireStringln(this.em.fichierErreur, "Opération " + op + " non définie avec ces types :");
		Ecriture.ecrireStringln(this.em.fichierErreur, "         Membre gauche : "+membreGauche+" de type " + id1.getType().getNom());
		Ecriture.ecrireStringln(this.em.fichierErreur, "         Membre droit : "+membreDroit+" de type " + id2.getType().getNom());
	}

	public void mauvaisTypeUnaire(Operateur op, Ident id) {
		this.em.ecritInfoBase(false);
		String operande;
		if(id.isVar()) {
			operande = id.getNom();
		}
		else {
			operande = "constante";
		}
		System.out.println("Opération " + op + " non définie avec ce type :");
		System.out.println("         Opérande : "+operande+" de type " + id.getType().getNom());
		Ecriture.ecrireStringln(this.em.fichierErreur, "Opération " + op + " non définie avec ce type :");
		Ecriture.ecrireStringln(this.em.fichierErreur, "         Opérande : "+operande+" de type " + id.getType().getNom());
	}
	
}
