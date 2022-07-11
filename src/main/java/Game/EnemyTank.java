package Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyTank extends Tank {
    private final BufferedImage image;
    private final BufferedImage rotatedImage;

    private int cd;
    private int dir_cd;
    private final Random random;
    private static final int SHOOTING_INTERVAL = 60;
    private static final int CHANGE_DIRECTION_INTERVAL = 250;
    
    protected EnemyTank(GameMap2D map, int hp, int speed, byte direction, SimpleVector2 position, Image image) {
        super(map, hp, speed, direction, position);
        this.image = (BufferedImage) image;
        rotatedImage = new BufferedImage(this.image.getWidth(), this.image.getHeight(), BufferedImage.TYPE_INT_RGB);
        setDirection(direction);
        random = new Random();
        dir_cd = cd = 0;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(rotatedImage, (int) (position.getX() - size.getX() / 2), (int) (position.getY() - size.getY() / 2), (int) size.getX(), (int) size.getY(), null);

        if(dir_cd < 0) {
            setDirection((byte) (random.nextInt(100) % 4));
            dir_cd = CHANGE_DIRECTION_INTERVAL;
        }

        if(cd <= 0)
            fire();

        cd--;
        dir_cd--;

        if(!move())
            dir_cd -= CHANGE_DIRECTION_INTERVAL / 5;
    }

    private void fire() {
        map.addMapObject(new Projectile(map, position.clone(), 5, getDirection(), false));
        cd = SHOOTING_INTERVAL;
    }

    @Override
    protected void setDirection(byte direction) {
        super.setDirection(direction);
        int width = image.getWidth();
        int height = image.getHeight();
        Graphics2D graphics2D = (Graphics2D) rotatedImage.getGraphics();
        graphics2D.rotate(Math.toRadians(90 * direction), height / 2f, width / 2f);
        graphics2D.drawRenderedImage(image, null);
    }

}
