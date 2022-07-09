package Game;

import java.awt.*;

public class TestMapObject extends MapObject2D {
    private final float speed;

    public TestMapObject(GameMap2D map, float speed) {
        super(map, new SimpleVector2(20, 20), new SimpleVector2(20, 20));
        this.speed = speed;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int) getPosition().getX(), (int) getPosition().getY(), (int) size.getX(), (int) size.getY());
        position.move(1 * speed, 1 * speed);
        SimpleVector2 tilePos = map.positionToTile(position);
        if(!map.getMapData().isValidTile((int)tilePos.getX(), (int)tilePos.getY())) {
            position.setX(1);
            position.setY(1);
            return;
        }
        if (map.getMapData().getTile((int) tilePos.getX(), (int) tilePos.getY()) == 5) {
            map.getMapData().setTile((int) tilePos.getX(), (int) tilePos.getY(), 0);
            destroy();
        }
        g.setColor(map.getMapData().getTile((int) tilePos.getX(), (int) tilePos.getY()) != 0 ? GameMap2D.COLLISION_COLOR : GameMap2D.COLLIDER_COLOR);
        SimpleVector2 mapPos = map.positionToMap(position);
        g.fillRect((int) mapPos.getX(), (int) mapPos.getY(), map.getTileWidth(), map.getTileHeight());
    }
}
