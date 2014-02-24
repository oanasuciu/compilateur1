package operation;

public class Mul extends Operation {

	@Override
	public String getYVMText() {
		return "imul";
	}

	@Override
	public String toString() {
		return "Mul";
	}

}
