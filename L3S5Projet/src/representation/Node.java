package representation;

import javax.swing.ImageIcon;

public abstract class Node implements Event{
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

	public String getDescription() {
		return description;
	}
}