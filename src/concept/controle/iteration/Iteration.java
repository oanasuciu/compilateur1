package concept.controle.iteration;

import concept.controle.StructureControle;
import concept.ident.Ident;
import yaka.Constante;
import yaka.Yaka;


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
			Yaka.em.expressionNonBooleen(id);
		}
		
	}
	
	public void fait(){
		decIteration();
		Yaka.yvm.goTo("FAIRE" + (this.stringNumerotation()));
		Yaka.yvm.etiquette("FAIT" + (this.stringNumerotation()));
		
	}
}