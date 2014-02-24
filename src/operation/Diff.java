package operation;

public class Diff extends Operation {

	@Override
	public String getYVMText() {
		return "idiff";
	}

	@Override
	public String toString() {
		return "Diff";
	}
	
}
