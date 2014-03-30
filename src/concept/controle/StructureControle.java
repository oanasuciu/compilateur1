package concept.controle;

import java.util.ArrayList;

public class StructureControle {
	private ArrayList<Integer> numerotationIteration;
	private int profondeurIteration = 0;

	public StructureControle() {
		numerotationIteration = new ArrayList<Integer>();
	}

	public void incIteration() {
		if (numerotationIteration.size() <= profondeurIteration) {
			numerotationIteration.add(1);
		} else {
			numerotationIteration.set(profondeurIteration, (numerotationIteration.get(profondeurIteration)) + 1);
		}
		profondeurIteration++;
	}

	public void decIteration() {
		if (numerotationIteration.size() <= profondeurIteration) {
			numerotationIteration.add(profondeurIteration, 0);
		} else {
			numerotationIteration.set(profondeurIteration, 0);
		}
		profondeurIteration--;
	}

	public String stringNumerotation() {
		String res = "";
		for (int i = 0; i < profondeurIteration; i++) {
			int val = numerotationIteration.get(i);
			if (val == 0)
				return res;
			res += "_" + val;
		}
		return res;
	}

	public void reInit() {
		numerotationIteration.clear();
	}
}