package yaka;

import java.io.OutputStream;

public class YVM {
	private static OutputStream ficYVM;
	
	public YVM(){
		ficYVM = Ecriture.ouvrir("Coucou_maman");
	}
	public static void ecrireEntete(){
		Ecriture.ecrireStringln(ficYVM,"entete");
	}
	
	public static void ecrireOuvrePrinc(){
		Ecriture.ecrireStringln(ficYVM,"ouvrePrinc "+Yaka.tabIdent.nbVar()*2);
	}

	public static void ecrireIdent(int val){
		Ecriture.ecrireStringln(ficYVM, "iconst "+val);
	}
	
	public static void ecrireIdent(String s, int val){
		Ecriture.ecrireStringln(ficYVM, s+" "+val);
	}
	
	public static void ecrireOp(String s){
		Ecriture.ecrireStringln(ficYVM, s);
	}
}
