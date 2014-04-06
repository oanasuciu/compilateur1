package concept.expression.operation;

import type.Type;
import yaka.Constante;
import yaka.Yaka;

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
	public void faitOperation() {
		Yaka.yvm.imul();
	}

}
