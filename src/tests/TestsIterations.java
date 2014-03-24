package tests;

import java.io.IOException;

import org.junit.Test;

import yaka.Yaka;

public class TestsIterations {

	@Test
	public void test4() throws IOException {
		Yaka.main(new String[] {"dataTst\\test4\\test4s", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test4\\test4r.yvm", "dataTst\\test4\\test4s.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test4\\test4r.asm", "dataTst\\test4\\test4s.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test4\\test4r.out", "dataTst\\test4\\TEST4S.OUT");
	}

	@Test
	public void testIterationImbrique() throws IOException {
		Yaka.main(new String[] {"dataTst\\test4imb\\test4imbs", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test4imb\\test4imbr.yvm", "dataTst\\test4\\test4imbs.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test4\\test4imbr.asm", "dataTst\\test4\\test4imbs.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test4\\test4imbr.out", "dataTst\\test4\\TEST4IMBS.OUT");
	}
}
