package representation;

public abstract class NodeDecorator extends Node implements Event{
	protected Node wrappedNode;
	
	public NodeDecorator(Node wrappedNode) {
        super(wrappedNode.description); // 使用被装饰节点的描述
        this.wrappedNode = wrappedNode;
    }
	
	public Node getWrappedNode() {
        return wrappedNode;
    }

    @Override
    public void display() {
        wrappedNode.display();
    }

    @Override
    public Node chooseNext() {
        return wrappedNode.chooseNext();
    }

}
