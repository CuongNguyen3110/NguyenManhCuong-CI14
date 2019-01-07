package game;

import game.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // static: quan li
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static void addNew(GameObject object){
        gameObjects.add(object);
    }

    public static void clearAll() {
        gameObjects.clear();
    }

    public static void runAll() {
        for(int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.run();
        }
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.render(g);
        }
    }

    // dinh nghia doi tuong
//    public BufferedImage image;
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;

    public GameObject() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        addNew(this); // cu tao moi thi them object vao mang gameObjects
    }

    public void run() {
        this.position.add(this.velocity);
    }

    public void render(Graphics g) {
        if(this.renderer != null) {
            this.renderer.render(g,this);
        }
    }
}
