package Game;

import javax.swing.*;
import java.awt.*;

public abstract class Tank  {
    private int hp;
    private final int speed;
    private byte direction;
    private SimpleVector2 position;


    protected Tank(int hp, int speed, byte direction) {
        this.hp = hp;
        this.speed =speed;
        this.direction =direction;
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
        if(direction > 3 || direction < 0)
            throw new IllegalArgumentException();
        this.direction = direction;
    }
    public void move (){
        switch (direction) {
            case 0 -> position.move(0, 1);
            case 1 -> position.move(1, 0);
            case 2 -> position.move(0, -1);
            case 3 -> position.move(-1, 0);
        }
    }
}
