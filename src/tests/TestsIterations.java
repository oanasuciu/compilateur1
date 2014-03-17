package tests;

import java.io.IOException;

import org.junit.Test;

import yaka.Yaka;

public class TestsIterations extends TestsAffectationsEntreesSorties {

	@Test
	public void test4() throws IOException {
		Yaka.main(new String[] {"dataTst\\test4\\test4s"});
		// comparaison YVM
		compare("dataTst\\test4\\test4r.yvm", "dataTst\\test4\\test4s.yvm");
		// comparaison ASM
		compare("dataTst\\test4\\test4r.asm", "dataTst\\test4\\test4s.asm");
		// comparaison sortie EXE
		compare("dataTst\\test4\\test4r.out", "dataTst\\test4\\test4s.out");
	}
}
