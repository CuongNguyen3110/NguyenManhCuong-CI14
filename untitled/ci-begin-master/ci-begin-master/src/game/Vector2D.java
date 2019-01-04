package game;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D add(Vector2D other) {
        return this.add(other.x, other.y);
    }

    public Vector2D subtract(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D subtract(Vector2D other) {
        return this.subtract(other.x, other.y);
    }

    public Vector2D scale(float rate) {
        this.x *= rate;
        this.y *= rate;
        return this;
    }

    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D other) {
        return this.set(other.x, other.y);
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public float getLength() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2D setLength(float length) {
        float currentLength = this.getLength();
        if(currentLength != 0) {
            float rate = length / this.getLength();
            this.scale(rate);
        }
        return this;
    }

    public float getAngle() {
        return (float)Math.atan(this.y / this.x);
    }

    public Vector2D setAngle(float angle) {
        float currentLength = this.getLength();
        this.x = currentLength * (float)Math.cos(angle);
        this.y = currentLength * (float)Math.sin(angle);
        return this;
    }
}
