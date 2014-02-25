package operation;

import yaka.Constante;

public class Inf extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "iinf";
	}

	@Override
	public String toString() {
		return "Inf";
	}

	@Override
	public boolean accepteType(int typeATester) {
		return typeATester == Constante.ENTIER;
	}

	@Override
	public int typeResultat() {
		return Constante.BOOLEEN;
	}
}
