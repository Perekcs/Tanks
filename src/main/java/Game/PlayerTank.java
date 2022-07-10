package Game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class PlayerTank extends Tank {
    Image kabanchik;
    InputHandler kabanchik2;
    BufferedImage kabanchik3;
    BufferedImage kabanchik4;

    private int cd;
    private static final int SHOOTING_INTERVAL = 50;

    protected PlayerTank(GameMap2D map, int hp, int speed, byte direction, SimpleVector2 position, Image image, InputHandler inputHandler) {
        super(map, hp, speed, direction, position);
        kabanchik = image;
        kabanchik2 = inputHandler;
        kabanchik3 = (BufferedImage) kabanchik;

        setDirection(direction);

        cd = 0;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(kabanchik4, (int) (position.getX() - size.getX() / 2), (int) (position.getY() - size.getY() / 2), (int) size.getX(), (int) size.getY(), null);

        if (kabanchik2.getMoveHorizontal() == 1)
            setDirection((byte) 1);
        else if (kabanchik2.getMoveHorizontal() == -1)
            setDirection((byte) 3);

        if (kabanchik2.getMoveVertical() == 1)
            setDirection((byte) 0);
        else if (kabanchik2.getMoveVertical() == -1)
            setDirection((byte) 2);

        if(cd > 0)
            cd--;
        if(cd <= 0 && kabanchik2.isFiring())
            fire();

        if (kabanchik2.getMoveVertical() != 0 || kabanchik2.getMoveHorizontal() != 0)
            move();

        if(GameWindow.DEBUG) {
            g.setColor(Color.RED);
            g.fillRect((int) (position.getX()), (int) (position.getY()), 3, 3);
            g.drawLine((int) position.getX(), -100, (int) position.getX(), 1000);
            g.drawLine(-100, (int) position.getY(), 1000, (int) position.getY());
        }
    }

    private void fire() {
        map.addMapObject(new Projectile(map, position.clone(), 3, getDirection(), true));
        cd = SHOOTING_INTERVAL;
    }

    @Override
    protected void setDirection(byte direction) {
        super.setDirection(direction);
        final double rads = Math.toRadians(90 * direction);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(kabanchik3.getWidth() * cos + kabanchik3.getHeight() * sin);
        final int h = (int) Math.floor(kabanchik3.getHeight() * cos + kabanchik3.getWidth() * sin);
        final BufferedImage rotatedImage = new BufferedImage(w, h, kabanchik3.getType());
        final AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads, 0, 0);
        at.translate(-kabanchik3.getWidth() / 2, -kabanchik3.getHeight() / 2);
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        kabanchik4 = rotateOp.filter(kabanchik3, rotatedImage);
    }
}
