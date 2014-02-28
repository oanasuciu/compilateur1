package operation;

import type.Type;
import yaka.Constante;

public class And extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "iand";
	}

	@Override
	public String toString() {
		return "And";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return typeATester == Constante.BOOLEEN;
	}

	@Override
	public Type typeResultat() {
		return Constante.BOOLEEN;
	}
}
