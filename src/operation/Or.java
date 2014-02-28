package operation;

import type.Type;
import yaka.Constante;

public class Or extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "ior";
	}

	@Override
	public String toString() {
		return "Or";
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
