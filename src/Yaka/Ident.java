package Yaka;

abstract class Ident {
	protected String nom;
	protected int type;
	
	
	
	public Ident(String nom) {
		this.nom=nom;
	}
	
	public Ident(String nom, int type) {
		this.nom=nom;
		this.type=type;
	}
}