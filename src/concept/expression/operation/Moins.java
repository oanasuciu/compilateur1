package concept.expression.operation;

import generation.YVM;
import type.Type;
import yaka.Constante;

public class Moins extends OperateurUnaire {

	@Override
	public String toString() {
		return "Moins";
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
		yvm.ineg();
	}

}
