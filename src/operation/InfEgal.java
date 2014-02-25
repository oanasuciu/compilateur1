package operation;

import yaka.Constante;

public class InfEgal extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "iinfegal";
	}

	@Override
	public String toString() {
		return "InfEgal";
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
