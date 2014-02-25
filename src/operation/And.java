package operation;

import yaka.Constante;

public class And extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "iand";
	}

	@Override
	public String toString() {
		return "And";
	}

	@Override
	public boolean accepteType(int typeATester) {
		return typeATester == Constante.BOOLEEN;
	}

	@Override
	public int typeResultat() {
		return Constante.BOOLEEN;
	}
}
