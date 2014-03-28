package tests;

import java.io.IOException;

import org.junit.Test;

import yaka.Yaka;

public class TestsConditionnelle {
	@Test
	public void test5() throws IOException {
		Yaka.main(new String[] {"dataTst\\test5\\test5s", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test5\\test5r.yvm", "dataTst\\test5\\test5s.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test5\\test5r.asm", "dataTst\\test5\\test5s.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test5\\test5r.out", "dataTst\\test5\\TEST5S.OUT");
	}
	
	@Test
	public void test5imb() throws IOException {
		Yaka.main(new String[] {"dataTst\\test5\\test5ibs", "1"});
		// comparaison YVM
		CompareUtils.compare("dataTst\\test5\\test5ibr.yvm", "dataTst\\test5\\test5ibs.yvm");
		// comparaison ASM
		CompareUtils.compare("dataTst\\test5\\test5ibr.asm", "dataTst\\test5\\test5ibs.asm");
		// comparaison sortie EXE
		CompareUtils.compare("dataTst\\test5\\test5ibr.out", "dataTst\\test5\\TEST5IBS.OUT");
	}
}
