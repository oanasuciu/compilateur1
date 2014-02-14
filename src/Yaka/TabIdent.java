package Yaka;

public class TabIdent {
	private HashYVM<String,Ident> table;
	
	public TabIdent(int taille){
		this.table = new HashYVM<String,Ident>(taille);
	}
	
	public Ident chercheIdent(String clef){...}
	
	public boolean existeIdent(String clef){...}
	
	public void rangeIdent(String clef, Ident id){...}
}
