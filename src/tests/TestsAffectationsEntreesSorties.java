package tests;

import java.io.IOException;

import org.junit.Test;

import yaka.Yaka;

public class TestsAffectationsEntreesSorties {

	@Test
	public void test3() throws IOException {
		Yaka.main(new String[] {"dataTst\\test3\\test3s", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test3\\test3r.yvm", "dataTst\\test3\\test3s.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test3\\test3r.asm", "dataTst\\test3\\test3s.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test3\\test3r.out", "dataTst\\test3\\test3s.out");
	}
	
	@Test
	public void test3Erreurs() throws IOException {
		Yaka.main(new String[] {"dataTst\\test3\\test3es", "1"});
		// comparaison fichiers erreurs
		CompareUtils.compare("dataTst\\test3\\test3er.err", "dataTst\\test3\\test3es.err");

	}
}
