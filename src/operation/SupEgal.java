package operation;

import yaka.Constante;

public class SupEgal extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "isupegal";
	}

	@Override
	public String toString() {
		return "SupEgal";
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
