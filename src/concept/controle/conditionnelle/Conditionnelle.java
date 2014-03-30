package concept.controle.conditionnelle;

import concept.controle.StructureControle;
import yaka.Yaka;

public class Conditionnelle extends StructureControle {

	public void alors() {
		incIteration();
		Yaka.yvm.iffaux("SINON" + (this.stringNumerotation()));
	}

	public void sinon() {
		Yaka.yvm.goTo("FSI" + (this.stringNumerotation()));
		Yaka.yvm.etiquette("SINON" + (this.stringNumerotation()));
	}

	public void fsi() {
		Yaka.yvm.etiquette("FSI" + (this.stringNumerotation()));
		decIteration();
	}
}