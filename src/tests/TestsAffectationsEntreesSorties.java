package tests;

import java.io.IOException;

import org.junit.Test;

import yaka.Yaka;

public class TestsAffectationsEntreesSorties extends TestsExpressions{

	@Test
	public void test3() throws IOException {
		Yaka.main(new String[] {"dataTst\\test3\\test3s"});
		// comparaison YVM
		compare("dataTst\\test3\\test3r.yvm", "dataTst\\test3\\test3s.yvm");
		// comparaison ASM
		compare("dataTst\\test3\\test3r.asm", "dataTst\\test3\\test3s.asm");
		// comparaison sortie EXE
		compare("dataTst\\test3\\test3r.out", "dataTst\\test3\\test3s.out");
	}
	
	@Test
	public void test3Erreurs() throws IOException {
		Yaka.main(new String[] {"dataTst\\test3\\test3Erreurs"});
		// comparaison fichiers erreurs
		compare("dataTst\\test3\\erreurs.txt", "errorLog.txt");

	}
}
