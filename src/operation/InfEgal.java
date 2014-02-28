package operation;

import type.Type;
import yaka.Constante;

public class InfEgal extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "iinfegal";
	}

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
	
}
