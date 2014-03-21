package tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import utils.FilenameUtils;

/**
 * 
 * @author Oana-maxi
 *
 */
public class CompareUtils {
	
	public static void compare(String nomFichierReference, String nomFichierCompilation) throws IOException{
		BufferedReader fichierReference = new BufferedReader(new FileReader(FilenameUtils.separatorsToSystem(nomFichierReference)));
		BufferedReader fichierCompilation = new BufferedReader(new FileReader(FilenameUtils.separatorsToSystem(nomFichierCompilation)));
		
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
}
