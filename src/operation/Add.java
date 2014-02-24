package operation;

public class Add extends Operation {

	@Override
	public String getYVMText() {
		return "iadd";
	}

	@Override
	public String toString() {
		return "Add";
	}

}