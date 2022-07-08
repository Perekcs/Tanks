package Game;

public class SimpleVector2 {
    private float x;
    private float y;

    public SimpleVector2() {
        this(0, 0);
    }

    public SimpleVector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public SimpleVector2 move(SimpleVector2 delta) {
        return move(delta.x, delta.y);
    }

    public SimpleVector2 move(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
        return this;
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
}
