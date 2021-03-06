package Game;

import java.awt.*;
import java.util.LinkedList;

public class Projectile extends MapObject2D {
    private final boolean isPlayerProjectile;
    private final byte direction;
    private final float speed;

    public Projectile(GameMap2D map, SimpleVector2 position, float speed, byte direction, boolean isPlayerProjectile) {
        super(map, new SimpleVector2(10, 10), position);
        this.isPlayerProjectile = isPlayerProjectile;
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public void paint(Graphics g) {
        switch (direction) {
            case 0 -> position.move(0, -1 * speed);
            case 1 -> position.move(1 * speed, 0);
            case 2 -> position.move(0, 1 * speed);
            case 3 -> position.move(-1 * speed, 0);
        }
        g.setColor(Color.RED);
        g.fillRect((int) (getPosition().getX() - size.getX() / 2), (int) (getPosition().getY() - size.getY() / 2), (int) size.getX(), (int) size.getY());
        SimpleVector2 tilePos = map.positionToTile(position);
        if (!map.getMapData().isValidTile((int) tilePos.getX(), (int) tilePos.getY())) {
            destroy();
            return;
        } else {
            int tile = map.getMapData().getTile((int) tilePos.getX(), (int) tilePos.getY());
            if(tile > 0 && tile < 6) {
                map.getMapData().setTile((int) tilePos.getX(), (int) tilePos.getY(), 0);
                destroy();
            } else if(tile != 0 && tile != 11)
                destroy();
            else
            {
                LinkedList<MapObject2D> objectsOnTile = map.getObjectsOnPosition(position);
                if(objectsOnTile.size() < 1)
                    return;
                for (var object: objectsOnTile) {
                    if(object == this)
                        continue;
                    if(isPlayerProjectile && object instanceof EnemyTank e)
                        e.destroy();
                    else if (!isPlayerProjectile && object instanceof PlayerTank p)
                        p.destroy();
                }

            }
        }
        if(GameWindow.DEBUG) {
            g.setColor(map.getMapData().getTile((int) tilePos.getX(), (int) tilePos.getY()) != 0 ? GameMap2D.COLLISION_COLOR : GameMap2D.COLLIDER_COLOR);
            SimpleVector2 mapPos = map.positionToMap(position);
            g.fillRect((int) mapPos.getX(), (int) mapPos.getY(), map.getTileWidth(), map.getTileHeight());
        }
    }
}
