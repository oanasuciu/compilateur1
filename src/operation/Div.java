package operation;

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
	public boolean accepteType(int typeATester) {
		return typeATester == Constante.ENTIER;
	}

	@Override
	public int typeResultat() {
		return Constante.ENTIER;
	}

}
