package concept.controle.conditionnelle;

import yaka.Constante;
import yaka.Yaka;
import concept.controle.StructureControle;
import concept.ident.Ident;

public class Conditionnelle extends StructureControle {

	public void alors() {
		incIteration();
		Ident id = Yaka.expression.recupereTete();
		if (id.getType() == Constante.BOOLEEN){
			Yaka.yvm.iffaux("SINON"+(this.stringNumerotation()));
		} else {
			Yaka.em.structureControle.expressionStructureControleNonBooleen(id);
		}
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