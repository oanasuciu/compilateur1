package operation;

import type.Type;
import yaka.Constante;

public class Egal extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "iegal";
	}

	@Override
	public String toString() {
		return "Egal";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return (typeATester == Constante.BOOLEEN || typeATester == Constante.ENTIER);
	}

	@Override
	public Type typeResultat() {
		return Constante.BOOLEEN;
	}
	
}
