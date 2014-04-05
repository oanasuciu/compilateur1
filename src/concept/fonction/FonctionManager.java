package concept.fonction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import concept.ident.Ident;
import yaka.Constante;
import yaka.Yaka;

public class FonctionManager {
	private Stack<Fonction> pileFonctionCourante;
	
	public void declareFonctionIdent(String nom) {
		Fonction fonctionCourante = new Fonction();
		fonctionCourante.setNom(nom);
		fonctionCourante.setRetour(Yaka.declaration.getTypeCourant());
		pileFonctionCourante.push(fonctionCourante);
		
	}
	
	public void declareFonctionParam(String nom) {
		Fonction fonctionCourante = pileFonctionCourante.peek();
		fonctionCourante.ajouterParam(nom, Yaka.declaration.getTypeCourant());
	}
	
	/**
	 * Méthode chargée de mettre les bons offsets aux paramètres
	 */
	public void declareFonctionParamFin() {
		Fonction fonctionCourante = pileFonctionCourante.peek();
		fonctionCourante.setOffset();
		Yaka.tabIdent.rangeFonction(fonctionCourante);
	}
	
	public void declareFonctionFin() {
		pileFonctionCourante.pop();
	}
	
	public void retourne() {
		Fonction fonctionCourante = pileFonctionCourante.peek();
		Ident id = Yaka.expression.recupereTete();
		if (id.getType() == fonctionCourante.getRetour() || id.getType() == Constante.ERREUR) {
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
		pileFonctionCourante.push(f);
		f.initVerifParam();
	}
	
	public void appelleFonctionParam() {
		Ident id = Yaka.expression.recupereTete();
		if(!this.iteratorParamsAttendus.hasNext()) {
			Yaka.em.nbParamInvalide(pileFonctionCourante.peek());
			return;
		}
		Ident idAttendu = this.iteratorParamsAttendus.next();
		if(idAttendu.getType() != id.getType() && id.getType() != Constante.ERREUR) {
			Yaka.em.typeParamInvalide(pileFonctionCourante.peek(), idAttendu);
		}
	}
	
	public void appelleFonctionFin() {
		Fonction fonctionCourante = pileFonctionCourante.pop();
		if(this.iteratorParamsAttendus.hasNext()) {
			Yaka.em.nbParamInvalide(fonctionCourante);
			return;
		}
		Yaka.yvm.call(fonctionCourante.getNom());
	}
}
