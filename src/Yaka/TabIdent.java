package Yaka;
import java.util.HashMap;

public class TabIdent {
	private HashMap<String,Ident> table;
	
	public TabIdent(int taille){
		this.table = new HashMap<String,Ident>(taille);
	}
	
	public Ident chercheIdent(String clef){
		return new Ident();
	}
	
	public boolean existeIdent(String clef){
		return false;
	}
	
	public void rangeIdent(String clef, Ident id){
		
	}
}
