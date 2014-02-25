package operation;

import yaka.Constante;

public class Or extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "ior";
	}

	@Override
	public String toString() {
		return "Or";
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
