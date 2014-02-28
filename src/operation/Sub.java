package operation;

import type.Type;
import yaka.Constante;

public class Sub extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "isub";
	}

	@Override
	public String toString() {
		return "Sub";
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