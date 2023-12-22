package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import backGround.Bgm;

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


/**
 * The GameFrame class represents the main game window where game graphics are displayed.
 */
public class GameFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int windowWidth = 1400; // Window width
    private int windowHeight = 700; // Window height
    private BackGroundPanel backgroundPanel = new BackGroundPanel();
    
    
    /**
     * Launches the game window.
     */
    public void launch() {
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setTitle("Dungeons & Dragons");// Set the window title
        add(backgroundPanel);
        setVisible(true);
        Bgm.playMusic("music/bgm.mp3");// Playing background music
    }
    
    
    /**
     * Updates the background image of the current window.
     *
     * @param newImage The new background image to set.
     */
    public void updateBackground(ImageIcon newImage) {
//        System.out.println("Updated background image : " + newImage.getDescription()); // Add debugging information
        backgroundPanel.setBackgroundImage(newImage);
        backgroundPanel.repaint();
    }
    /**
     * The BackGroundPanel class is an inner class representing the background panel within the game window.
     */
    private class BackGroundPanel extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image bg;

        public BackGroundPanel() {
            try {
                bg = ImageIO.read(new File("image/start_image.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        /**
         * Sets the background image for the panel.
         *
         * @param imgIcon The ImageIcon to set as the background image.
         */
        public void setBackgroundImage(ImageIcon imgIcon) {
            bg = imgIcon.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg != null) {
            	// Here the image is scaled to the same size as the JPanel.
                g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
    }
}

