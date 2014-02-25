package yaka;

public abstract class Ident {
	protected String nom;
	protected int type;
	protected int valeur;

	public Ident(String nom) {
		this.nom = nom;
	}

	public Ident(int type) {
		this.type = type;
	}

	public Ident(String nom, int type) {
		this.nom = nom;
		this.type = type;
	}

	public Ident(String nom, int type, int valeur) {
		this.nom = nom;
		this.type = type;
		this.valeur = valeur;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * Getter pour l'attribut valeur
	 * 
	 * @return valeur de l'identificateur courant
	 */
	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public void setValeur(boolean valeur) {
		this.valeur = (valeur) ? -1 : 0;
	}
	
	/**
	 * Renvoie le texte pour le chargement de l'identité dans la YVM selon le type de l'identificateur (variable/constante)
	 * 
	 * @return le texte correspondant au type de l'identificateur
	 */
	abstract public String getYVMText();
}