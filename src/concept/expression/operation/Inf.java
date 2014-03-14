package concept.expression.operation;

import generation.YVM;
import type.Type;
import yaka.Constante;

public class Inf extends OperateurBinaire {

	@Override
	public String toString() {
		return "Inf";
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
		yvm.iinf();
	}
}
