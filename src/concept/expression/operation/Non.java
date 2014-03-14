package concept.expression.operation;

import generation.YVM;
import type.Type;
import yaka.Constante;

public class Non extends OperateurUnaire {

	@Override
	public String toString() {
		return "Non";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return typeATester == Constante.BOOLEEN;
	}

	@Override
	public Type typeResultat() {
		return Constante.BOOLEEN;
	}

	@Override
	public void visiteYVM(YVM yvm) {
		yvm.inot();
	}
	
}
