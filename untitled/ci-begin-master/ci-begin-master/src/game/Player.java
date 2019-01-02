package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    Vector2D position;
//    float x;
//    float y;

    public Player() {
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position = new Vector2D(200, 400);
//        this.x = 200;
//        this.y = 400;
    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x, (int)this.position.y, null);
    }

    public void run() {
        this.move();
        this.limitPosition();
        this.fire();
    }

    int count; // TODO: continue editing
    private void fire() {
        count++;
        if(count > 20) {
            if(GameWindow.isFirePress) {
                PlayerBullet bullet = new PlayerBullet();
                bullet.x = this.position.x;
                bullet.y = this.position.y;
                GamePanel.bullets.add(bullet);
                this.count = 0;
            }
        }
    }

    private void limitPosition() {
        if(this.position.x < 0) {
            this.position.x = 0;
        }
        if(this.position.y < 0) {
            this.position.y = 0;
        }
        if(this.position.x > 384 - this.image.getWidth()) {
            this.position.x = 384 - this.image.getWidth();
        }
        if(this.position.y > 600 - this.image.getHeight()) {
            this.position.y = 600 - this.image.getHeight();
        }
    }

    private void move() {
        if(GameWindow.isUpPress) {
            this.position.y -= 5;
        }
        if(GameWindow.isDownPress) {
            this.position.y += 5;
        }
        if(GameWindow.isLeftPress) {
            this.position.x -= 5;
        }
        if(GameWindow.isRightPress) {
            this.position.x += 5;
        }
    }
}
