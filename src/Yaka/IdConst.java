package Yaka;

public class IdConst extends Ident {
	private int valeur;
	
	public IdConst(String nom, int type, int valeur){
		super(nom, type);
		this.valeur=valeur;
	}

	@Override
	public String toString() {
		return "IdConst [nom=" + nom + ", type=" + type + ", valeur=" + valeur
				+ "]";
	}
}
