package yaka;

public class Sortie {
	
	public void ecrireTete() {
		Ident id = Yaka.expression.recupereTete();
		if(id == null) {
			Yaka.em.aucuneValeurAEcrire();
			return;
		}
		id.getType().visiteEcriture(this);
	}

	public void ecrireEnt() {
		Yaka.yvm.ecrireEnt();
	}

	public void ecrireBool() {
		Yaka.yvm.ecrireBool();
	}

	public void ecrireErreur() {
		// ne fait rien
	}
}