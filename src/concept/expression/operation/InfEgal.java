package concept.expression.operation;

import generation.YVM;
import type.Type;
import yaka.Constante;

public class InfEgal extends OperateurBinaire {

	@Override
	public String toString() {
		return "InfEgal";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return typeATester == Constante.ENTIER;
	}

	@Override
	public Type typeResultat() {
		return Constante.BOOLEEN;
	}

	@Override
	public void visiteYVM(YVM yvm) {
		yvm.iinfegal();
	}
	
}
