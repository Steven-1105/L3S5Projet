import java.util.Scanner;

import gui.GameFrame;
import representation.*;
import univers.PlayerCharacter;
import univers.Race;
import univers.Boss;
import univers.Enemy;

public class Main {
    public static void main(String[] args) {
    	//创建游戏窗口
        GameFrame gameFrame = new GameFrame();
        gameFrame.launch();
        
        // 创建游戏实例并开始
        Game game = new Game(gameFrame);
        game.start();    
    }
}
