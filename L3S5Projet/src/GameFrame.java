import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import backGround.Bgm;

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JFrame {
    private int windowWidth = 1400; // 窗口宽度
    private int windowHeight = 700; // 窗口高度
    private BackGroundPanel backgroundPanel = new BackGroundPanel();
    

    public void launch() {
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("龙与小树林");
        add(backgroundPanel);
        setVisible(true);
        Bgm.playMusic("music/bgm.mp3");
    }
    
    public void updateBackground(ImageIcon newImage) {
        backgroundPanel.setBackgroundImage(newImage);
        backgroundPanel.repaint();
    }

    private class BackGroundPanel extends JPanel {
        private Image bg;

        public BackGroundPanel() {
            try {
                bg = ImageIO.read(new File("image/start_image.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        public void setBackgroundImage(ImageIcon imgIcon) {
            bg = imgIcon.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg != null) {
                // 这里将图片缩放到和 JPanel 一样的大小
                g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}

