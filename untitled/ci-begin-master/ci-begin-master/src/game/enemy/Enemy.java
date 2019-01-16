package game.enemy;

import game.FrameCounter;
import physics.BoxColider;
import physics.Physics;
import game.GameObject;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxColider boxColider;
    FrameCounter fireCounter;

    public Enemy() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
        this.renderer = new Animation(images);
        this.velocity.set(2,0);
        this.boxColider = new BoxColider(this, 30,30);
        this.fireCounter = new FrameCounter(5);
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

    public void fire() {
        if(this.fireCounter.run()) {
//            EnemyBullet enemyBullet = new EnemyBullet();
            EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
            enemyBullet.position.set(this.position);
            this.fireCounter.reset();
        }
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }
}
