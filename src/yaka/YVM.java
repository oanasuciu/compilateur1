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
}
