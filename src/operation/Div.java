package operation;

import type.Type;
import yaka.Constante;

public class Div extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "idiv";
	}

	@Override
	public String toString() {
		return "Div";
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