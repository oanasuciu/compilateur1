package operation;

public abstract class Operation {
	/**
	 * Renvoie le texte utilisé dans la YVM selon le type de l'opération (plus/moins/div/...)
	 * 
	 * @return le texte correspondant à l'opération
	 */
	abstract public String getYVMText();

	@Override
	public String toString() {
		return "Operation";
	}
}