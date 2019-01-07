package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class SphereBullet extends GameObject{
    public SphereBullet() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/sphere-bullets/3.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0, -7);
    }
}
