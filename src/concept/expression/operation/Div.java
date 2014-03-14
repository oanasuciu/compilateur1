package concept.expression.operation;

import generation.YVM;
import type.Type;
import yaka.Constante;

public class Div extends OperateurBinaire {

	@Override
	public String toString() {
		return "Div";
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
		yvm.idiv();
	}

}
