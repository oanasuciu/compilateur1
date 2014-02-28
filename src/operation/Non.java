package operation;

import type.Type;
import yaka.Constante;

public class Non extends OperateurUnaire {

	@Override
	public String getYVMText() {
		return "inon";
	}

	@Override
	public String toString() {
		return "Non";
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
