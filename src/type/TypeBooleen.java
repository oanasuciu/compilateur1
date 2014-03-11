package type;

import yaka.Sortie;

public class TypeBooleen extends Type {

	public TypeBooleen() {
		super("Booléeen");
	}

	@Override
	public void visiteEcriture(Sortie s) {
		s.ecrireBool();
	}

}
