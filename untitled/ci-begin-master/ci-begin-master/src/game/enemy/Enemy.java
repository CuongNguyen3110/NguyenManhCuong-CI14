package game.enemy;

import game.GameObject;
import game.Vector2D;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Enemy extends GameObject {
    public Enemy() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
        this.renderer = new Animation(images);
        this.velocity.set(2,0);
    }

    @Override
    public void run() {
        super.run();
        this.fire();
        if(this.position.x > 384 - 30) {
            this.position.x = 384 - 30;
            this.velocity.set(-2,0);
        }
        if(this.position.x < 0) {
            this.position.x =0;
            this.velocity.set(2,0);
        }
    }

    int count;
    public void fire() {
        this.count++;
        if(this.count > 30) {
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.position.set(this.position.x, this.position.y);
            this.count = 0;
        }
    }
}
