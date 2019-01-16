package game;

import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sphere extends GameObject {
    FrameCounter fireCounter;

    public Sphere() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/sphere/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/sphere/3.png"));
        this.renderer = new Animation(images);
        this.fireCounter = new FrameCounter(20);
//        this.image = SpriteUtils.loadImage("assets/images/sphere/3.png");
    }

    @Override
    public void run() {
        super.run();
        this.fire();
    }

    private void fire() {
        if(this.fireCounter.run()) {
//            SphereBullet bullet = new SphereBullet();
            SphereBullet bullet = GameObject.recycle(SphereBullet.class);
            bullet.position.set(this.position);
            this.fireCounter.reset();
        }
    }

}
