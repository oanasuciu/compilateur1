package operation;

import yaka.Constante;

public class Non extends OperateurUnaire {

	@Override
	public String getYVMText() {
		return "inon";
	}

	@Override
	public String toString() {
		return "Non";
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
