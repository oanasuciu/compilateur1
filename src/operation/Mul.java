package operation;

import yaka.Constante;

public class Mul extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "imul";
	}

	@Override
	public String toString() {
		return "Mul";
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
