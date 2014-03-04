package operation;

import type.Type;
import yaka.Constante;
import yaka.YVM;

public class Add extends OperateurBinaire {

	@Override
	public String toString() {
		return "Add";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return typeATester == Constante.ENTIER;
	}

	@Override
	public Type typeResultat() {
		return Constante.ENTIER;
	}

	@Override
	public void visiteYVM(YVM yvm) {
		yvm.iadd();
	}

}