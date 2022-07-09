package Game;

import java.awt.*;

public abstract class MapObject2D {
    protected final SimpleVector2 position;
    protected final SimpleVector2 size;
    protected final GameMap2D map;

    protected MapObject2D(GameMap2D map, SimpleVector2 size, SimpleVector2 position) {
        this.map = map;
        this.size = size;
        this.position = position;
    }

    public SimpleVector2 getPosition() {
        return position;
    }

    public SimpleVector2 getSize() {
        return size;
    }

    public void destroy() {
        map.removeMapObject(this);
    }

    public void paint(SimpleVector2 position, Graphics g) {
        paint((int) position.getX(), (int) position.getY(), g);
    }

    public abstract void paint(int x, int y, Graphics g);
}
