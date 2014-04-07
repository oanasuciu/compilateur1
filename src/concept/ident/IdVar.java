package concept.ident;

import java.util.ArrayList;

import type.Type;
import yaka.Constante;
import yaka.Yaka;

public class IdVar extends Ident {
	private static int sharedOffset = -2;
	private int offset;

	public IdVar(String nom, Type type) {
		super(nom, type);
		this.offset = sharedOffset;
		sharedOffset -= 2;
	}
	
	public IdVar(Type type) {
		super(type);
	}
	
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public static void reInit() {
		sharedOffset = -2;
	}

	@Override
	public String toString() {
		return "IdVar [nom=" + nom + ", type=" + type + "]";
	}

	@Override
	public boolean isVar() {
		return true;
	}
	

	@Override
	public void chargeValeur() {
		Yaka.yvm.iload(this.offset);
	}

	@Override
	public void affectation(Ident partieDroite) {
		// on regarde si les types sont compatibles :
		if(partieDroite.getType() != Constante.ERREUR && this.getType() != Constante.ERREUR && partieDroite.getType() != this.getType()) {
			Yaka.em.affectation.mauvaisTypeAffectation(this, partieDroite);
			return;
		}
		Yaka.yvm.istore(this.offset);
	}

	@Override
	public String getTypeIdent() {
		return "variable";
	}

	@Override
	public Ident dupliqueConstante() {
		return null;
	}

	@Override
	public void lireEntier() {
		if(this.getType() != Constante.ERREUR && this.getType() != Constante.ENTIER) {
			Yaka.em.es.lireEntierSurNonEntier(this);
		}
		Yaka.yvm.lireEnt(this.offset);
	}

	@Override
	public ArrayList<IdVar> getParams() {
		return null;
	}
}
