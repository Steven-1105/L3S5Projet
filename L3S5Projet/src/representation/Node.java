package representation;

import javax.swing.ImageIcon;

public abstract class Node {
	// Attributs
	protected String description;
	private static int NEXTID = 1;// Variable statique permettant de générer l'identifiant unique suivant
	protected final int id;
	private ImageIcon image;
	
	// Constructeurs
	public Node(String description, String imagePath) {
		this.description = description;
		this.id = NEXTID ++;
		this.image = new ImageIcon(imagePath);
	}

	// Méthodes
	public abstract void display();

	public abstract Node chooseNext();// Default method, will be overridden in subclasses
	  
	public int getId() {
		return id;
	}
	
	public ImageIcon getImage() {
		return image;
	}
}