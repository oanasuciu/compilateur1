package tests;
import java.io.IOException;

import org.junit.Test;

import yaka.Yaka;

public class TestsDeclarations {
	
	@Test
	public void test1() throws IOException {
		Yaka.main(new String[] {"dataTst\\test1\\test1s", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test1\\test1r.yvm", "dataTst\\test1\\test1s.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test1\\test1r.asm", "dataTst\\test1\\test1s.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test1\\test1r.out", "dataTst\\test1\\TEST1S.OUT");
	}
}
