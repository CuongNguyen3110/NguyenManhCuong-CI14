package game;

import tklibs.SpriteUtils;

public class SphereBullet extends GameObject{
    public SphereBullet() {
        this.image = SpriteUtils.loadImage("assets/images/sphere-bullets/3.png");
        this.velocity.set(0, -7);
    }
}
