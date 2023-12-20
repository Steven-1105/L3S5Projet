package backGround;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Bgm {
  public static void playMusic(String filepath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            Player player = new Player(fileInputStream);

            // 创建一个新线程来播放音乐，以免阻塞 GUI 或其他处理
            new Thread(() -> {
                try {
                    player.play(); // 播放
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
