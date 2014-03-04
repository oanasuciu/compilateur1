package operation;

import type.Type;
import yaka.Constante;
import yaka.YVM;

public class Sub extends OperateurBinaire {

	@Override
	public String toString() {
		return "Sub";
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
		yvm.isub();
	}
}