package game.enemy;

import game.FrameCounter;
import game.GameObject;
import game.Vector2D;

public class EnemySummoner extends GameObject {
    FrameCounter frameCounter;
    Vector2D position;

    public EnemySummoner() {
        this.frameCounter = new FrameCounter(60);
        this.position = new Vector2D(300,100);
    }

    @Override
    public void run() {
        if(this.frameCounter.run()) {
            Enemy enemy = GameObject.recycle(Enemy.class);
            enemy.position.set(this.position);
            this.frameCounter.reset();
        }
    }
}
