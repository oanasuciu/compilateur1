package type;

import yaka.Sortie;

public class TypeEntier extends Type {

	public TypeEntier() {
		super("Entier");
	}

	@Override
	public void visiteEcriture(Sortie s) {
		s.ecrireEnt();
	}

}
