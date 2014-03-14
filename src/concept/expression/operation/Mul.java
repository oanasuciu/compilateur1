package concept.expression.operation;

import generation.YVM;
import type.Type;
import yaka.Constante;

public class Mul extends OperateurBinaire {

	@Override
	public String toString() {
		return "Mul";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return typeATester == Constante.ENTIER;
	}

	@Override
	public Type typeResultat() {
		return Constante.ENTIER;
	}

	@Override
	public void visiteYVM(YVM yvm) {
		yvm.imul();
	}

}
