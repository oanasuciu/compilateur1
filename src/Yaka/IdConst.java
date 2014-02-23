package Yaka;

public class IdConst extends Ident {

	public IdConst(String nom, int type, int valeur) {
		super(nom, type, valeur);
	}

	public IdConst(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "IdConst [nom=" + nom + ", type=" + type + ", valeur=" + valeur
				+ "]";
	}
}
