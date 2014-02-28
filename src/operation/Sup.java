package operation;

import type.Type;
import yaka.Constante;

public class Sup extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "isup";
	}

	@Override
	public String toString() {
		return "Sup";
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
