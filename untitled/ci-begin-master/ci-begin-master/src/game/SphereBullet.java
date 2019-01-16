package game;

import game.enemy.Enemy;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class SphereBullet extends GameObject{
    BoxColider boxColider;
    public SphereBullet() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/sphere-bullets/3.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0, -7);
        this.boxColider = new BoxColider(this,30,30);
    }

    @Override
    public void run() {
        super.run();
        Enemy enemy = GameObject.findIntersected(Enemy.class, this.boxColider);
        if (enemy != null) {
            enemy.deactive();
        }
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(this.position.y < -100) {
            this.deactive();
        }
    }
}
