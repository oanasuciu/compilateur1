package concept.expression.operation;

import generation.YVM;
import type.Type;
import yaka.Constante;

public class Diff extends OperateurBinaire {
	
	@Override
	public String toString() {
		return "Diff";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return (typeATester == Constante.BOOLEEN || typeATester == Constante.ENTIER);
	}

	@Override
	public Type typeResultat() {
		return Constante.BOOLEEN;
	}

	@Override
	public void visiteYVM(YVM yvm) {
		yvm.idiff();
	}
}
