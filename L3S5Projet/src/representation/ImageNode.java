package representation;

import javax.swing.ImageIcon;

import gui.GameFrame;

public class ImageNode extends NodeDecorator{
	private ImageIcon image;
	private GameFrame gameFrame;

	public ImageNode(Node wrappedNode, String imagePath, GameFrame gameFrame) {
        super(wrappedNode);
        this.image = new ImageIcon(imagePath);
        this.gameFrame = gameFrame;
//        System.out.println("ImageNode created with image path: " + imagePath);
    }
	
	public ImageIcon getImage() {
        return image;
    }
	
	@Override
    public void display() {
		// 更新 GameFrame 中的背景图片
        gameFrame.updateBackground(image);
        // 然后调用被装饰对象的 display 方法
        super.display();
    }

	 // chooseNext 方法继承自 NodeDecorator
}
