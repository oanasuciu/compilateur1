package operation;

import yaka.Constante;

public class Diff extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "idiff";
	}

	@Override
	public String toString() {
		return "Diff";
	}

	@Override
	public boolean accepteType(int typeATester) {
		return (typeATester == Constante.BOOLEEN || typeATester == Constante.ENTIER);
	}

	@Override
	public int typeResultat() {
		return Constante.BOOLEEN;
	}
	
}
