package concept.conditionnelle;

import concept.ident.Ident;
import yaka.Constante;
import yaka.Yaka;

public class Conditionnelle {
	private int etiquetteCourante;
	
	public Conditionnelle() {
		this.etiquetteCourante = 0;
	}

	public void alors() {
		Ident id = Yaka.expression.recupereTete();
		if (id.getType() == Constante.BOOLEEN){
			Yaka.yvm.iffaux("SINON"+(++this.etiquetteCourante));
		} else {
			Yaka.em.expressionNonBooleen(id);
		}
	}

	public void sinon() {
		Yaka.yvm.goTo("FSI"+(this.etiquetteCourante));
		Yaka.yvm.etiquette("SINON"+(this.etiquetteCourante));
	}

	public void fsi() {
		Yaka.yvm.etiquette("FSI"+(this.etiquetteCourante--));
	}
	
	public void reInit() {
		this.etiquetteCourante = 0;
	}
	
}