package Yaka;

abstract class Ident {
	protected String nom;
	protected int type;
	protected int valeur;

	public Ident(String nom) {
		this.nom = nom;
	}

	public Ident(String nom, int type) {
		this.nom = nom;
		this.type = type;
	}

	public Ident(String nom, int type, int valeur) {
		this.nom = nom;
		this.type = type;
		this.valeur = valeur;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public void setValeur(boolean valeur) {
		this.valeur = (valeur) ? -1 : 0;
	}
}