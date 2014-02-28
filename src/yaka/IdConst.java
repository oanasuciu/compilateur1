package yaka;

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
	public String getYVMText() {
		return "iconst";
	}
}
