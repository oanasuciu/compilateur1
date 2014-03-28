package tests;

import java.io.IOException;

import org.junit.Test;

import yaka.Yaka;

public class TestsConditionnelle {
	@Test
	public void test1() throws IOException {
		Yaka.main(new String[] {"dataTst\\test5\\test5s", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test5\\test5r.yvm", "dataTst\\test5\\test5s.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test5\\test5r.asm", "dataTst\\test5\\test5s.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test5\\test5r.out", "dataTst\\test5\\TEST5S.OUT");
	}
}
