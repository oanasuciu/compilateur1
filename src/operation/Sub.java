package operation;

import yaka.Constante;

public class Sub extends OperateurBinaire {

	@Override
	public String getYVMText() {
		return "isub";
	}

	@Override
	public String toString() {
		return "Sub";
	}

	@Override
	public boolean accepteType(int typeATester) {
		return typeATester == Constante.ENTIER;
	}

	@Override
	public int typeResultat() {
		return Constante.ENTIER;
	}
}