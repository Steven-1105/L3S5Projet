package representation;
import backGround.Bgm;

/**
 * A decorator class that adds sound playback capabilities to nodes.
 */
public class SoundNode extends NodeDecorator {
    private String soundFilePath;
    
    /**
     * Constructs a SoundNode that wraps around an existing node, adding sound capabilities.
     *
     * @param wrappedNode   The node to be wrapped by this SoundNode.
     * @param soundFilePath The path to the sound file to be played for this node.
     */
    public SoundNode(Node wrappedNode, String soundFilePath) {
        super(wrappedNode);
        this.soundFilePath = soundFilePath;
    }
    
    /**
     * Plays the sound associated with this node.
     */
    public void playSound(String soundFilePath) {
    	Bgm.playMusic(soundFilePath);
    }

    /**
     * Displays the node's content and plays the associated sound.
     */
    @Override
    public void display() {
        super.display(); // Display the description of the decorated node
        playSound(soundFilePath); // Play music
    }

    @Override
    public Node chooseNext() {
    	// Play music
        Bgm.playMusic(soundFilePath);
        // Go to the next node
        Node nextNode = wrappedNode.chooseNext();
        // Stop the music
        Bgm.stopMusic();
        return nextNode;
    }
}