package operation;

import type.Type;
import yaka.Constante;

public class Add extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "iadd";
	}

	@Override
	public String toString() {
		return "Add";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return typeATester == Constante.ENTIER;
	}

	@Override
	public Type typeResultat() {
		return Constante.ENTIER;
	}

}