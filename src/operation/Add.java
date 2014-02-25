package operation;

import yaka.Constante;

public class Add extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "iadd";
	}

	@Override
	public String toString() {
		return "Add";
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