package concept.controle.iteration;

import yaka.Constante;
import yaka.Yaka;
import concept.controle.StructureControle;
import concept.ident.Ident;


public class Iteration extends StructureControle {
	
	public void tantque(){
		incIteration();
		Yaka.yvm.etiquette("FAIRE" + (this.stringNumerotation()));
	}
	
	public void faire(){
		Ident id = Yaka.expression.recupereTete();
		if (id.getType() == Constante.BOOLEEN) {
			Yaka.yvm.iffaux("FAIT" + (this.stringNumerotation()));
		} else {
			Yaka.em.structureControle.expressionStructureControleNonBooleen(id);
		}
		
	}
	
	public void fait(){
		Yaka.yvm.goTo("FAIRE" + (this.stringNumerotation()));
		Yaka.yvm.etiquette("FAIT" + (this.stringNumerotation()));
		decIteration();
	}
}