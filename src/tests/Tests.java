package tests;
import java.io.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
	
	public void compareLignes(String l1, String l2){
		assertEquals(l1, l2);
	}
	
	@Test
	public void compare(String nomFichierReference, String nomFichierCompilation) throws IOException{
		BufferedReader fichierReference = new BufferedReader(new FileReader(nomFichierReference));
		BufferedReader fichierCompilation = new BufferedReader(new FileReader(nomFichierCompilation));
		
		String l1;   //variable pour contenir la ligne
		String l2;
		while(true){
			while((l1 = fichierReference.readLine()) != null) {
				if(l1.charAt(0) != ';')
					break;
			}
			if(l1 == null)
				break;
			while((l2 = fichierCompilation.readLine()) != null) {
				if(l2.charAt(0) != ';')
					break;
			}
			if(l2 == null)
				break;
			compareLignes(l1, l2);
		}
	}

	public boolean erreurs(){
		return false;
	}

}
