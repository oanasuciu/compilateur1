package tests;

import java.io.IOException;

import org.junit.Test;

import yaka.*;

public class TestsExpressions extends TestsDeclarations {

	@Test
	public void test2() throws IOException {
		Yaka.main(new String[] {"dataTst\\test2\\test2s"});
		// comparaison YVM
		compare("dataTst\\test2\\test2r.yvm", "dataTst\\test2\\test2s.yvm");
		// comparaison ASM
		compare("dataTst\\test2\\test2r.asm", "dataTst\\test2\\test2s.asm");
		// comparaison sortie EXE
		compare("dataTst\\test2\\test2r.out", "dataTst\\test2\\test2s.out");
	}
	
	@Test
	public void test2Erreurs() throws IOException {
		Yaka.main(new String[] {"dataTst\\test2\\test2sErreurs"});
		// comparaison fichiers erreurs
		compare("dataTst\\test2\\erreurs.txt", "errorLog.txt");

	}
}
