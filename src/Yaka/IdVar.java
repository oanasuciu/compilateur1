package Yaka;

public class IdVar extends Ident {
	private static int sharedOffset = -2;
	private int offset;
	
	public IdVar(String nom, int type){
		super(nom, type);
		this.offset = sharedOffset;
		sharedOffset -= 2;
	}

	@Override
	public String toString() {
		return "IdVar [nom=" + nom + ", type=" + type + ", offset=" + offset
				+ "]";
	}
}
