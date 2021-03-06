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
		Yaka.main(new String[] {"dataTst\\test4\\test4ibs", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test4\\test4ibr.yvm", "dataTst\\test4\\test4ibs.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test4\\test4ibr.asm", "dataTst\\test4\\test4ibs.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test4\\test4ibr.out", "dataTst\\test4\\TEST4IBS.OUT");
	}
}
