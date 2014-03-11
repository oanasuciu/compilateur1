package operation;

import type.Type;
import yaka.Constante;
import yaka.YVM;

public class And extends OperateurBinaire {

	@Override
	public String toString() {
		return "And";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return typeATester == Constante.BOOLEEN;
	}

	@Override
	public Type typeResultat() {
		return Constante.BOOLEEN;
	}

	@Override
	public void visiteYVM(YVM yvm) {
		yvm.iand();
	}
}
