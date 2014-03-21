package concept.iteration;

import java.util.ArrayList;

import yaka.Yaka;


public class Iteration {
	static ArrayList<Integer> numerotationIteration;
	static int profondeurIteration = 0;
	
	public Iteration(){
		numerotationIteration = new ArrayList<Integer>();
	}
	
	public void incIteration(){
		System.out.println("COUCOU0\n");
		if (numerotationIteration.size() <= profondeurIteration){
			System.out.println("COUCOU1\n");
			numerotationIteration.add(1);
			System.out.println("COUCOU2\n");
		}else{
			System.out.println("COUCOU2,5\n");
			numerotationIteration.set(profondeurIteration, (numerotationIteration.get(profondeurIteration)) +1);
			System.out.println("COUCOU3\n");
		}
		System.out.println("COUCOU4\n");
		profondeurIteration++;
		System.out.println("COUCOU5\n");
	}
	
	public void decIteration(){
		numerotationIteration.add(profondeurIteration, 0);
		profondeurIteration--;
	}
	
	public static String stringNumerotation(ArrayList<Integer> numIt){
		String res = "";
		for(Integer val : numIt) {
			if (val == 0) return res;
			res+="_"+val;
		}
		return res;
	}
	
	public void tantque(){
		System.out.println("COUCOU14\n");
		incIteration();
		Yaka.yvm.tantque(numerotationIteration);
	}
	
	public void faire(){
		Yaka.yvm.faire(numerotationIteration);
	}
	
	public void fait(){
		Yaka.yvm.fait(numerotationIteration);
		decIteration();
	}

	public void ReInit() {
		numerotationIteration.clear();
	}
	
}