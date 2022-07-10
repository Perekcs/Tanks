package Game;

import javax.swing.*;
import java.awt.*;

public abstract class Tank extends MapObject2D {
    private int hp;
    private final int speed;
    private byte direction;
    //private SimpleVector2 position;


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
        SimpleVector2 tilePosition = map.positionToTile(position);
        SimpleVector2 desiredPosition = position;
        switch (direction) {
            case 0 -> desiredPosition.move(0, 1);
            case 1 -> desiredPosition.move(1, 0);
            case 2 -> desiredPosition.move(0, -1);
            case 3 -> desiredPosition.move(-1, 0);
        }
        if (desiredPosition.getX() >= 0 && desiredPosition.getY() >= 0 && desiredPosition.getX() <= 640 && desiredPosition.getY() <= 640) {
            position.set(desiredPosition);
        }

    }
}
