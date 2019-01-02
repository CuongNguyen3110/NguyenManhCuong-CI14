package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    BufferedImage image;
    Vector2D position;
//    float x;
//    float y;

    public Background() {
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.position = new Vector2D(0, 600 - this.image.getHeight());
//        this.x = 0;
//        this.y = 600 - this.image.getHeight();
    }
    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }
    public void run() {
        if(this.position.y < 0) {
            this.position.add(0,1);
//            this.position.y++;
        }
    }
}
