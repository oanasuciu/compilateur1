package operation;

import type.Type;
import yaka.Constante;

public class SupEgal extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "isupegal";
	}

	@Override
	public String toString() {
		return "SupEgal";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return typeATester == Constante.ENTIER;
	}

	@Override
	public Type typeResultat() {
		return Constante.BOOLEEN;
	}

}
