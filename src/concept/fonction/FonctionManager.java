package concept.fonction;

import java.util.ArrayList;
import java.util.Iterator;

import concept.ident.Ident;
import yaka.Constante;
import yaka.Yaka;

public class FonctionManager {
	private Fonction fonctionCourante;
	private Iterator<Ident> iteratorParamsAttendus;
	
	public void declareFonctionIdent(String nom) {
		this.fonctionCourante = new Fonction();
		this.fonctionCourante.setNom(nom);
		this.fonctionCourante.setRetour(Yaka.declaration.getTypeCourant());
		
	}
	
	public void declareFonctionParam(String nom) {
		this.fonctionCourante.ajouterParam(nom, Yaka.declaration.getTypeCourant());
	}
	
	/**
	 * Méthode chargée de mettre les bons offsets aux paramètres
	 */
	public void declareFonctionParamFin() {
		this.fonctionCourante.setOffset();
		Yaka.tabIdent.rangeFonction(this.fonctionCourante);
	}
	
	public void retourne() {
		Ident id = Yaka.expression.recupereTete();
		if (id.getType() == this.fonctionCourante.getRetour() || id.getType() == Constante.ERREUR) {
			Yaka.yvm.ireturn(0);
		}
	}
	
	public void appelleFonctionDebut(String nom) {
		Fonction f = Yaka.tabIdent.chercheFonction(nom);
		if(f == null) {
			Yaka.em.fonctionInexistante(nom);
		}
		else {
			Yaka.yvm.reserveRetour();
		}
		this.fonctionCourante = f;
		this.iteratorParamsAttendus = f.getParams().iterator();
	}
	
	public void appelleFonctionParam() {
		Ident id = Yaka.expression.recupereTete();
		if(!this.iteratorParamsAttendus.hasNext()) {
			Yaka.em.nbParamInvalide(this.fonctionCourante);
			return;
		}
		Ident idAttendu = this.iteratorParamsAttendus.next();
		if(idAttendu.getType() != id.getType() && id.getType() != Constante.ERREUR) {
			Yaka.em.typeParamInvalide(this.fonctionCourante, idAttendu);
		}
	}
	
	public void appelleFonctionFin() {
		if(this.iteratorParamsAttendus.hasNext()) {
			Yaka.em.nbParamInvalide(fonctionCourante);
			return;
		}
		Yaka.yvm.call(this.fonctionCourante.getNom());
	}
}
