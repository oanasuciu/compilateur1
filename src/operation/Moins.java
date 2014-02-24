package operation;

public class Moins extends Operation {

	@Override
	public String getYVMText() {
		// ou isub ? Contradiction entre page 4 (exemple) et page 5
		return "ineg";
	}

	@Override
	public String toString() {
		return "Moins";
	}

}
