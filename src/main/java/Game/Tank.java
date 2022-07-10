package Game;

import javax.swing.*;
import java.awt.*;

public abstract class Tank extends MapObject2D {
    private int hp;
    private final int speed;
    private byte direction;

    protected Tank(GameMap2D map, int hp, int speed, byte direction, SimpleVector2 position) {
        super(map, new SimpleVector2(32, 32), position);
        this.hp = hp;
        this.speed = speed;
        this.direction = direction;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public byte getDirection() {
        return direction;
    }

    protected void setDirection(byte direction) {
        if (direction > 3 || direction < 0)
            throw new IllegalArgumentException();
        this.direction = direction;
    }

    public void move() {
        SimpleVector2 desiredPosition = position.clone();
        switch (direction) {
            case 0 -> desiredPosition.move(0, -1 * speed);
            case 1 -> desiredPosition.move(speed, 0);
            case 2 -> desiredPosition.move(0, speed);
            case 3 -> desiredPosition.move(-1 * speed, 0);
        }
        SimpleVector2 desiredTilePosition = map.positionToTile(desiredPosition);
        if (desiredPosition.getX() >= 0 && desiredPosition.getY() >= 0 && desiredPosition.getX() < map.getWidth() && desiredPosition.getY() < map.getHeight()
                && map.getMapData().getTile((int) desiredTilePosition.getX(), (int) desiredTilePosition.getY()) == 0 || map.getMapData().getTile((int) desiredTilePosition.getX(), (int) desiredTilePosition.getY()) == 12)
            position.set(desiredPosition);
    }
}
