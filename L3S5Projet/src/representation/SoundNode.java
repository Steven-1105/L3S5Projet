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
        super.display(); // 显示被装饰节点的内容
        playSound(soundFilePath); // 播放音乐
    }

    @Override
    public Node chooseNext() {
        // 播放音乐
        Bgm.playMusic(soundFilePath);
        // 进入下一个节点
        Node nextNode = wrappedNode.chooseNext();
        // 停止音乐
        Bgm.stopMusic();
        return nextNode;
    }
}