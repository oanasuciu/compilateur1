package tests;

import java.io.IOException;

import org.junit.Test;

import yaka.Yaka;

public class TestsFonctions {

	@Test
	public void test6() throws IOException {
		Yaka.main(new String[] {"dataTst\\test6\\test6s", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test6\\test6r.yvm", "dataTst\\test6\\test6s.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test6\\test6r.asm", "dataTst\\test6\\test6s.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test6\\test6r.out", "dataTst\\test6\\TEST6S.OUT");
	}
	
	@Test
	public void test6Erreurs() throws IOException {
		Yaka.main(new String[] {"dataTst\\test6\\test6es", "1"});
		// comparaison fichiers erreurs
		CompareUtils.compare("dataTst\\tes6\\test6er.err", "dataTst\\test6\\test6es.err");

	}
}
