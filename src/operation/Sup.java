package operation;

import yaka.Constante;

public class Sup extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "isup";
	}

	@Override
	public String toString() {
		return "Sup";
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
