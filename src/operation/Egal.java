package operation;

import yaka.Constante;

public class Egal extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "iegal";
	}

	@Override
	public String toString() {
		return "Egal";
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
