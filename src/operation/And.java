package operation;

public class And extends Operation {

	@Override
	public String getYVMText() {
		return "iand";
	}

	@Override
	public String toString() {
		return "And";
	}
}
