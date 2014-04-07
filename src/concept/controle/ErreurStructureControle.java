package concept.controle;

import utils.Ecriture;
import concept.ident.Ident;
import erreur.ErreurManager;

public class ErreurStructureControle {
	private ErreurManager em;

	public ErreurStructureControle(ErreurManager em) {
		this.em = em;
	}

	public void expressionStructureControleNonBooleen(Ident id){
		this.em.ecritInfoBase(false);
		String expr;
		if(id.isVar()) {
			expr = id.getNom();
		}
		else {
			expr = "constante";
		}
		System.out.println("L'expression pour l'itération n'est pas booléenne.");
		System.out.println("         Expression : "+expr+" de type " + id.getType().getNom());
		Ecriture.ecrireStringln(this.em.fichierErreur, "L'expression pour l'itération n'est pas booléenne.");
		Ecriture.ecrireStringln(this.em.fichierErreur, "         Expression : "+expr+" de type " + id.getType().getNom());
	}
}
