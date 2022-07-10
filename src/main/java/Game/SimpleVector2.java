package Game;

public class SimpleVector2 implements Cloneable {
    private float x;
    private float y;

    public SimpleVector2() {
        this(0, 0);
    }

    public SimpleVector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public SimpleVector2(SimpleVector2 vector) {
        this(vector.x, vector.y);
    }

    public void move(SimpleVector2 delta) {
        move(delta.x, delta.y);
    }

    public void move(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
    }

    public void set(SimpleVector2 vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public SimpleVector2 clone() {
        return new SimpleVector2(this);
    }
}
