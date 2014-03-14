package type;

import concept.es.Sortie;

public class TypeErreur extends Type {

	public TypeErreur() {
		super("Erreur");
	}

	@Override
	public void visiteEcriture(Sortie s) {
		s.ecrireErreur();
	}
}
