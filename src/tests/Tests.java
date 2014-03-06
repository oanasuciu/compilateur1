package tests;
import java.io.*;

import org.junit.Test;

import yaka.Yaka;
import static org.junit.Assert.*;

public class Tests {
	
	public void compareLignes(String l1, String l2){
		assertEquals(l1, l2);
	}
	
	public void compare(String nomFichierReference, String nomFichierCompilation) throws IOException{
		BufferedReader fichierReference = new BufferedReader(new FileReader(nomFichierReference));
		BufferedReader fichierCompilation = new BufferedReader(new FileReader(nomFichierCompilation));
		
		String l1;   //variable pour contenir la ligne l1
		String l2;   //variable pour contenir la ligne l2
		while(true){
			while((l1 = fichierReference.readLine()) != null) {
				if(l1.charAt(0) != ';')
					break;
			}
			while((l2 = fichierCompilation.readLine()) != null) {
				if(l2.charAt(0) != ';')
					break;
			}
			// on est arrivé à la fin des 2 fichiers
			if(l1 == null && l2 == null)
				break;
			assertEquals(l1, l2);
		}
		fichierReference.close();
		fichierCompilation.close();
	}
	
	@Test
	public void test1() throws IOException {
		Yaka.main(new String[] {"donneesPourTests/test1_source"});
		// comparaison YVM
		compare("donneesPourTests/test1_yvm.yvm", "donneesPourTests/test1_source.yvm");
		// comparaison ASM
		compare("donneesPourTests/test1_asm.asm", "donneesPourTests/test1_source.asm");
	}
}
