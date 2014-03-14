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
				if(l1.length() > 0 && l1.charAt(0) != ';') {
					l1 = l1.trim();
					break;
				}
			}
			while((l2 = fichierCompilation.readLine()) != null) {
				if(l2.length() > 0 && l2.charAt(0) != ';') {
					l2 = l2.trim();
					break;
				}
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
		Yaka.main(new String[] {"dataTst\\test1\\test1s", "1"});
		// comparaison YVM
		compare("dataTst\\test1\\test1r.yvm", "dataTst\\test1\\test1s.yvm");
		// comparaison ASM
		compare("dataTst\\test1\\test1r.asm", "dataTst\\test1\\test1s.asm");
		// comparaison sortie EXE
		compare("dataTst\\test1\\test1r.out", "dataTst\\test1\\test1s.out");
	}
	
	@Test
	public void test2() throws IOException {
		Yaka.main(new String[] {"dataTst\\test2\\test2s", "1"});
		// comparaison YVM
		compare("dataTst\\test2\\test2r.yvm", "dataTst\\test2\\test2s.yvm");
		// comparaison ASM
		compare("dataTst\\test2\\test2r.asm", "dataTst\\test2\\test2s.asm");
		// comparaison sortie EXE
		compare("dataTst\\test2\\test2r.out", "dataTst\\test2\\test2s.out");
	}
}
