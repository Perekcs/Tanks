package Game;

public abstract class Tank {
    private int hp;
    private final int speed;
    private byte direction;

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
        if(direction >3 || direction < 0)
            throw new IllegalArgumentException();
        this.direction = direction;
    }
}
