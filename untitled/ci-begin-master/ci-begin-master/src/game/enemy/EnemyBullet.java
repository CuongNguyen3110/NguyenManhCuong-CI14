package game.enemy;

import game.GameObject;
import game.Player;
import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject {
    BoxColider boxColider;
    int damage;

    public EnemyBullet() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.renderer = new SingleImageRenderer(image);
        this.velocity.set(0,5);
        this.boxColider = new BoxColider(this, 30,30);
        this.damage = 1;
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObject.findIntersected(Player.class, this.boxColider);
        if (player != null) {
            player.playerTakeDamage(this.damage);
            this.deactive();
        }
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(this.position.y > 900) {
            this.deactive();
        }
    }
}
