package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    public GamePanel() {
        new Background();
        new Player();
//        this.background = new Background();
//        this.player = new Player();
//        this.bullets = new ArrayList<>();
////        this.bullets.add();
//        this.bullets.size();
//        this.bullets.get();
    }

    @Override
    public void paint(Graphics g) {
        // ve game
//        g.drawRect(100,100, 50,50);
//        g.drawImage(this.backgroundImage,this.backgroundX,this.backgroundY,null);
//        this.background.render(g);
//        this.player.render(g);
//        for(int i = 0; i < this.bullets.size(); i++) {
//            PlayerBullet bullet = this.bullets.get(i);
//            bullet.render(g);
        GameObject.renderAll(g);
    }

    public void gameloop() {
        long lastLoop = 0;
        long delay = 1000 / 60;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastLoop > delay) {
                this.runAll(); // ~logic
                this.renderAll(); // ~render
                lastLoop = currentTime;
            }
        }
    }
    public void runAll() {
//        this.background.run();
//        this.player.run();
//        for(int i = 0; i < this.bullets.size(); i++) {
//            PlayerBullet bullet = this.bullets.get(i);
//            bullet.run();
        GameObject.runAll();
    }
    public void renderAll() {
        this.repaint();
    }
}
