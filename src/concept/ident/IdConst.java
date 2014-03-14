package concept.ident;

import generation.YVM;
import type.Type;

public class IdConst extends Ident {

	public IdConst(String nom, Type type, int valeur) {
		super(nom, type, valeur);
	}
	
	public IdConst(Type type) {
		super(type);
	}

	public IdConst(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "IdConst [nom=" + nom + ", type=" + type + ", valeur=" + valeur
				+ "]";
	}

	@Override
	public boolean isVar() {
		return false;
	}

	@Override
	public void visiteYVM(YVM yvm) {
		yvm.iconst(this.valeur);
	}
}
