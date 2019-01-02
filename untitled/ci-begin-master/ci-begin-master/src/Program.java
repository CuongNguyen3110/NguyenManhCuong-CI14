import game.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        window.gamePanel.gameloop();
    }
}
