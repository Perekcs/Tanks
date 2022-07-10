package Game;

import java.awt.*;

public class PlayerTank extends Tank {
    Image kabanchik;
    InputHandler kabanchik2;

    protected PlayerTank(GameMap2D map, int hp, int speed, byte direction, SimpleVector2 position,Image image, InputHandler inputHandler) {
        super(map, hp, speed, direction, position);
        kabanchik = image;
        kabanchik2 = inputHandler;

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(kabanchik, (int) position.getX(), (int) position.getY(), null);
        if(kabanchik2.getMoveHorizontal() == 1){
            setDirection((byte) 1);
            move();
        }
        if(kabanchik2.getMoveHorizontal() == -1){
            setDirection((byte) 3);
            move();
        }
        if(kabanchik2.getMoveVertical() == 1){
            setDirection((byte) 0);
            move();
        }
        if(kabanchik2.getMoveVertical() == -1){
            setDirection((byte) 2);
            move();
        }
    }
}
