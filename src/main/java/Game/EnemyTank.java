package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyTank extends Tank {
    private final Bot bot;
    private final BufferedImage image;
    private final BufferedImage rotatedImage;

    private int cd;
    private static final int SHOOTING_INTERVAL = 50;
    
    protected EnemyTank(GameMap2D map, int hp, int speed, byte direction, SimpleVector2 position, Image image, Bot bot) {
        super(map, hp, speed, direction, position);
        this.image = (BufferedImage) image;
        this.bot = bot;
        rotatedImage = new BufferedImage(this.image.getWidth(), this.image.getHeight(), BufferedImage.TYPE_INT_RGB);
        setDirection(direction);

        cd = 0;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(rotatedImage, (int) (position.getX() - size.getX() / 2), (int) (position.getY() - size.getY() / 2), (int) size.getX(), (int) size.getY(), null);

        if (bot.getMoveBotHorizontal() == 1)
            setDirection((byte) 1);
        else if (bot.getMoveBotHorizontal() == -1)
            setDirection((byte) 3);

        if (bot.getMoveBotVertical() == 1)
            setDirection((byte) 0);
        else if (bot.getMoveBotVertical() == -1)
            setDirection((byte) 2);

        if(cd > 0)
            cd--;
        if(cd <= 0 && bot.isFiring())
            fire();
    }

    private void fire() {
        map.addMapObject(new Projectile(map, position.clone(), 7, getDirection(), true));
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
