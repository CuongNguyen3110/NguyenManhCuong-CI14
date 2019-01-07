package game.enemy;

import game.GameObject;
import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject {
    public EnemyBullet() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,5);
    }

    @Override
    public void run() {
        super.run();
    }
}
