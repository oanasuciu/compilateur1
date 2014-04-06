package concept.declaration;

import type.Type;
import yaka.Constante;
import yaka.Yaka;
import concept.ident.IdConst;
import concept.ident.IdFonction;
import concept.ident.IdVar;
import concept.ident.Ident;

public class Declaration {
	/**
	 * Le dernier type lu dans la grammaire
	 */
	private Type typeCourant;
	/**
	 * Le dernier identificateur lu dans la grammaire
	 */
	private String identCourant;
	/**
	 * La fonction dans laquelle on se trouve
	 */
	private IdFonction fonctionCourante;

	/**
	 * Déclaration d'une nouvelle variable
	 * 
	 * @param nom
	 *            Nom de la variable
	 */
	public void nouvelleVariable(String nom) {
		Ident id = new IdVar(nom, this.typeCourant);
		Yaka.tabIdent.rangeIdent(nom, id);
	}
	
	public void nouvelleConstante(String ident) {
		Ident id = Yaka.tabIdent.chercheIdent(ident);
		if(id == null) {
			Yaka.em.identificateurInexistant(ident);
			Yaka.tabIdent.rangeIdent(this.identCourant, new IdConst(this.identCourant, Constante.ERREUR));
			return;
		}
		Ident nouvelId = id.dupliqueConstante();
		if(nouvelId == null) {
			Yaka.em.declaration.affectationMauvaisIdentificateurDansConstante(this.identCourant, id);
			Yaka.tabIdent.rangeIdent(this.identCourant, new IdConst(this.identCourant, Constante.ERREUR));
			return;
		}
		nouvelId.setNom(this.identCourant);
		Yaka.tabIdent.rangeIdent(this.identCourant, nouvelId);
	}
	
	public void nouvelleConstante(int v) {
		IdConst id = new IdConst(identCourant, Constante.ENTIER);
		id.setValeur(v);
		Yaka.tabIdent.rangeIdent(this.identCourant, id);
	}
	
	public void nouvelleConstante(boolean b) {
		IdConst id = new IdConst(identCourant, Constante.BOOLEEN);
		id.setValeur(b);
		Yaka.tabIdent.rangeIdent(this.identCourant, id);
	}
	
	/*
	 * Déclaration de fonctions
	 */

	public void blocFonctionDebut() {
		Yaka.tabIdent.ouvreBloc();
	}
	
	public void fonctionPrincipaleDebut() {
		Yaka.tabIdent.nettoieLocaux();
		this.fonctionCourante = null;
		Yaka.yvm.ouvrePrinc();
	}
	
	public void enteteFonctionDebut(String nom) {
		Yaka.tabIdent.nettoieLocaux();
		IdFonction id = new IdFonction(nom, this.getTypeCourant());
		this.fonctionCourante = id;
		Yaka.yvm.etiquette(nom);
	}
	
	public void enteteFonctionParam(String nom) {
		this.fonctionCourante.ajouterParam(nom, this.getTypeCourant());
	}
	
	public void enteteFonctionParamFin() {
		this.fonctionCourante.setParamsOffset();
		Yaka.tabIdent.rangeFonction(this.fonctionCourante.getNom(), this.fonctionCourante);
	}
	
	public void declFonctionFin() {
		Yaka.tabIdent.fermeBloc();
	}
	
	/*
	 * Getters & Setters
	 */
	
	public IdFonction getFonctionCourante() {
		return fonctionCourante;
	}
	
	public Type getTypeCourant() {
		return this.typeCourant;
	}

	public void setTypeCourant(Type typeCourant) {
		this.typeCourant = typeCourant;
	}

	public void setIdentCourant(String identCourant) {
		this.identCourant = identCourant;
	}
}