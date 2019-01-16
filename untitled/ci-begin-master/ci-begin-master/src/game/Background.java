package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {

    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.renderer = new SingleImageRenderer(image);
        this.position.set(0, 600 - image.getHeight());
        this.velocity.set(0, 1);
        this.anchor.set(0, 0);
//        this.position = new Vector2D(0, 600 - this.image.getHeight());
//        this.x = 0;
//        this.y = 600 - this.image.getHeight();
    }

    @Override
    public void run() {
        super.run();
//        if(this.position.y < 0) {
//            this.position.add(0,1);
//            this.position.y++;
    }
}
