package type;

import concept.es.Sortie;

public class TypeBooleen extends Type {

	public TypeBooleen() {
		super("Booléen");
	}

	@Override
	public void visiteEcriture(Sortie s) {
		s.ecrireBool();
	}

}
