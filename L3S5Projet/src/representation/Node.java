package representation;

public abstract class Node {
	// Attributs
	protected String description;
	private static int NEXTID = 1;// Variable statique permettant de générer l'identifiant unique suivant
	protected final int id;
	
	// Constructeurs
	public Node(String description) {
		this.description = description;
		this.id = NEXTID ++;
	}

	// Méthodes
	public abstract void display();

	public abstract Node chooseNext();// Default method, will be overridden in subclasses
	  
	public int getId() {
		return id;
	}  
}