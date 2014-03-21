package tests;

import java.io.IOException;

import org.junit.Test;

import yaka.*;

public class TestsExpressions {

	@Test
	public void test2() throws IOException {
		Yaka.main(new String[] {"dataTst\\test2\\test2s", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test2\\test2r.yvm", "dataTst\\test2\\test2s.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test2\\test2r.asm", "dataTst\\test2\\test2s.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test2\\test2r.out", "dataTst\\test2\\TEST2S.OUT");
	}
	
	@Test
	public void test2Erreurs() throws IOException {
		Yaka.main(new String[] {"dataTst\\test2\\test2es", "1"});
		// comparaison fichiers erreurs
		CompareUtils.compare("dataTst\\test2\\test2er.err", "dataTst\\test2\\test2es.err");

	}
}
