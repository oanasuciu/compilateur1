package yaka;

public class IdVar extends Ident {
	private static int sharedOffset = -2;

	public IdVar(String nom, int type) {
		super(nom, type, sharedOffset);
		sharedOffset -= 2;
	}

	@Override
	public String toString() {
		return "IdVar [nom=" + nom + ", type=" + type + "]";
	}

	@Override
	public String getYVMText() {
		return "iload";
	}
}
