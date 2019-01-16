package game;

import game.renderer.Animation;
import game.renderer.SingleImageRenderer;
import physics.BoxColider;
import physics.Physics;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    Sphere sphereLeft;
    Sphere sphereRight;
    BoxColider boxColider;
    FrameCounter fireCounter;
    int hp;
    boolean immune; //bat tu

    public Player() {
        super();
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        this.renderer = new Animation(images);
        this.position.set(200, 400);
        this.sphereLeft = new Sphere();
        this.sphereRight = new Sphere();
        this.boxColider = new BoxColider(this,30,30);
        this.fireCounter = new FrameCounter(20);
        this.hp = 3;
        this.immune = false;
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.limitPosition();
        this.updateSpherePosition();
        this.fire();
        this.checkImmune();
    }

    int immuneCount;
    private void checkImmune() {
        if(this.immune) {
            this.immuneCount++;
            if(this.immuneCount > 60) {
                this.immune = false;
                this.immuneCount = 0;
            }
        }
    }

    private void updateSpherePosition() {
        this.sphereLeft.position.set(this.position).add(-30, 15);
        this.sphereRight.position.set(this.position).add(30, 15);
    }

    private void fire() {
        if(fireCounter.run()) {
            if(GameWindow.isFirePress) {
//                PlayerBullet bullet = new PlayerBullet();
//                bullet.position.set(this.position);
//                this.count = 0;
                float startAngle = -(float)Math.PI / 4;
                float endAngle = -3 * (float)Math.PI / 4;
                float offset = (endAngle - startAngle) / 4;

                for (int i = 0; i < 5; i++) {
//                    PlayerBullet bullet = new PlayerBullet();
                    PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
                    bullet.position.set(this.position.x, this.position.y);
                    bullet.velocity.setAngle(startAngle + offset * i);
                    this.fireCounter.reset();
                }
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
        if(this.position.x > 384 - 48) {
            this.position.x = 384 - 48;
        }
        if(this.position.y > 600 - 32) {
            this.position.y = 600 - 32;
        }
    }

    private void move() {
        float vX = 0;
        float vY = 0;
        if(GameWindow.isUpPress) {
            vY = -5;
//            this.position.y -= 5;
        }
        if(GameWindow.isDownPress) {
            vY = 5;
//            this.position.y += 5;
        }
        if(GameWindow.isLeftPress) {
            vX = -5;
//            this.position.x -= 5;
        }
        if(GameWindow.isRightPress) {
            vX = 5;
//            this.position.x += 5;
        }
        this.velocity.set(vX, vY).setLength(5);
    }

    @Override
    public BoxColider getBoxColider() {
        return this.boxColider;
    }

    public void playerTakeDamage(int damage) {
        if(this.immune) {
            return;
        }
        this.hp -= damage;
        if(this.hp <= 0) {
            this.hp = 0;
            this.deactive();
            this.sphereLeft.deactive();
            this.sphereRight.deactive();
        } else {
            this.immune = true;
        }
//        if(this.isActive) {
//            this.updateSpherePosition();
//        } else {
//            this.sphereLeft.deactive();
//            this.sphereRight.deactive();
//        }
    }

    int count;
    @Override
    public void render(Graphics g) {
        if(this.immune) {
            // nhay nhay
            this.count++;
            if(this.count > 2) {
                super.render(g);
                this.count = 0;
            }
        } else {
            super.render(g);
        }
    }
}
