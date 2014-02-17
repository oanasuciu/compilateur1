package Yaka;

public class IdVar extends Ident {
	private String nom;
	private int type;
	private int offset;
	
	public IdVar(String nom, int type){
		this.nom=nom;
		this.type=type;
	}
}
