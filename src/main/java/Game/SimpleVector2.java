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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleVector2 that = (SimpleVector2) o;

        if (Float.compare(that.x, x) != 0) return false;
        return Float.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SimpleVector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public SimpleVector2 clone() {
        return new SimpleVector2(this);
    }
}
