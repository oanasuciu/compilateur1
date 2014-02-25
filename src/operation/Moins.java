package operation;

import yaka.Constante;

public class Moins extends OperateurUnaire {

	@Override
	public String getYVMText() {
		// ou isub ? Contradiction entre page 4 (exemple) et page 5
		return "ineg";
	}

	@Override
	public String toString() {
		return "Moins";
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
