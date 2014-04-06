package concept.expression.operation;

import type.Type;
import yaka.Constante;
import yaka.Yaka;

public class Sup extends OperateurBinaire {

	@Override
	public String toString() {
		return "Sup";
	}

	@Override
	public boolean accepteType(Type typeATester) {
		return typeATester == Constante.ENTIER;
	}

	@Override
	public Type typeResultat() {
		return Constante.BOOLEEN;
	}

	@Override
	public void faitOperation() {
		Yaka.yvm.isup();
	}
	
}
