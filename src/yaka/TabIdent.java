package yaka;

import java.util.HashMap;

/*
 * TODO: Documenter cette fonction, notamment : qu'est-ce qu'elle renvoie quand pas d'élément trouvé ?
 */
public class TabIdent {
	private HashMap<String, Ident> table;

	public TabIdent(int taille) {
		this.table = new HashMap<String, Ident>(taille);
	}

	public Ident chercheIdent(String clef) {
		return table.get(clef);
	}

	public boolean existeIdent(String clef) {
		return table.containsKey(clef);
	}

	public void rangeIdent(String clef, Ident id) {
		table.put(clef, id);
	}

	@Override
	public String toString() {
		return "TabIdent [table=" + table + "]";
	}
}
