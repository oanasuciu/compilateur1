package concept.iteration;

import java.util.ArrayList;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import concept.ident.Ident;
import yaka.Constante;
import yaka.Yaka;


public class Iteration {
	static ArrayList<Integer> numerotationIteration;
	static int profondeurIteration = 0;
	
	public Iteration(){
		numerotationIteration = new ArrayList<Integer>();
	}
	
	public void incIteration(){
		if (numerotationIteration.size() <= profondeurIteration){
			numerotationIteration.add(1);
		}else{
			numerotationIteration.set(profondeurIteration, (numerotationIteration.get(profondeurIteration)) +1);
		}
		profondeurIteration++;
	}
	
	public void decIteration(){
		if (numerotationIteration.size() <= profondeurIteration){
			numerotationIteration.add(profondeurIteration, 0);
		} else {
			numerotationIteration.set(profondeurIteration, 0);
		}
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
		incIteration();
		Yaka.yvm.tantque(numerotationIteration);
	}
	
	public void faire(){
		Ident id = Yaka.expression.recupereTete();
		if (id.getType() == Constante.BOOLEEN){
			Yaka.yvm.faire(numerotationIteration);
		} else {
			Yaka.em.expressionNonBooleen(id);
		}
		
	}
	
	public void fait(){
		decIteration();
		Yaka.yvm.fait(numerotationIteration);
		
	}

	public void reInit() {
		numerotationIteration.clear();
	}
	
}