package representation;

import java.io.Serializable;

import javax.swing.ImageIcon;
import gui.GameFrame;

/**
 * A decorator class that adds an image feature to nodes.
 * It wraps around a standard node and associates an image with it,
 * which can be displayed in a GameFrame.
 */
public class ImageNode extends NodeDecorator implements Serializable{
    /**
     * The image associated with this node.
     */
    private transient ImageIcon image;

    /**
     * The game frame where the image will be displayed.
     */
    private transient GameFrame gameFrame;

    /**
     * Constructs an ImageNode that wraps around an existing node, adding image capabilities.
     *
     * @param wrappedNode The node to be wrapped by this ImageNode.
     * @param imagePath   The path to the image file to be displayed for this node.
     * @param gameFrame   The game frame where the image is to be displayed.
     */
    public ImageNode(Node wrappedNode, String imagePath, GameFrame gameFrame) {
        super(wrappedNode);
        this.image = new ImageIcon(imagePath);
        if (gameFrame == null) {
            throw new IllegalArgumentException("GameFrame cannot be null");
        }
        this.gameFrame = gameFrame;
    }

    /**
     * Gets the image associated with this node.
     *
     * @return The ImageIcon associated with this node.
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * Displays the node's content and updates the GameFrame's background with the node's image.
     */
    @Override
    public void display() {
        // Update the GameFrame's background image.
        if (gameFrame != null) {
            gameFrame.updateBackground(image);
        } else {
            throw new IllegalStateException("GameFrame is null when trying to display ImageNode.");
        }
        // Then call the display method of the wrapped node.
        super.display();
    }

    // The chooseNext method is inherited from NodeDecorator.
}
