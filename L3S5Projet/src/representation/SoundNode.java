package representation;

public class SoundNode extends NodeDecorator {
    private String soundFilePath;

    public SoundNode(Event wrappedNode, String soundFilePath) {
        super(wrappedNode);
        this.soundFilePath = soundFilePath;
    }

    @Override
    public void display() {
        // 播放声音的逻辑...
        wrappedNode.display();
    }

    @Override
    public Node chooseNext() {
        return wrappedNode.chooseNext();
    }
}