package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class GameMap2D {
    private final Map mapData;
    private final int width;
    private final int height;
    private final int tileWidth;
    private final int tileHeight;
    private final Image[] tiles;
    private final Image[] tanks;
    public static final Color COLLIDER_COLOR = new Color(30, 255, 255, 124);
    public static final Color COLLISION_COLOR = new Color(255, 234, 5, 157);
    private final LinkedList<MapObject2D> markedForRemoval;
    private final LinkedList<MapObject2D> pendingObjects;
    private final LinkedList<MapObject2D> mapObjects;

    public GameMap2D(Map mapData, int width, int height, InputHandler inputHandler) {
        this.mapData = mapData;
        this.width = width;
        this.height = height;
        tileWidth = width / mapData.getWidth();
        tileHeight = height / mapData.getHeight();
        tiles = loadTiles();
        tanks = loadTanks();
        mapObjects = new LinkedList<>();
        markedForRemoval = new LinkedList<>();
        pendingObjects = new LinkedList<>();
        spawnPlayer(inputHandler);
    }

    private void spawnPlayer(InputHandler inputHandler) {
        for (int y = 0; y < mapData.getHeight(); y++)
            for (int x = 0; x < mapData.getWidth(); x++)
                if (mapData.getTile(x, y) == 14) {
                    mapData.setTile(x, y, 0);
                    addMapObject(new PlayerTank(this, 1, 3, (byte) 1, tileToPosition(x, y), tanks[1], inputHandler));
                    return;
                }
        mapData.setTile(0, 0, 0);
        addMapObject(new PlayerTank(this, 1, 3, (byte) 1, tileToPosition(0, 0), tanks[1], inputHandler));
    }

    private Image[] loadTiles() {
        Image[] tiles = new Image[14];
        for (int i = 0; i < tiles.length; i++) {
            try {
                tiles[i] = ImageIO.read(Objects.requireNonNull(FieldPanel.class.getResource(String.format("/tiles/tile_%d.png", i))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tiles;
    }

    private Image[] loadTanks() {
        Image[] tanks = new Image[8];
        for (int i = 0; i < 4; i++) {
            try {
                tanks[i] = ImageIO.read(Objects.requireNonNull(FieldPanel.class.getResource(String.format("/tanks/tank_player_%d.png", i))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 4; i++) {
            try {
                tanks[i + 4] = ImageIO.read(Objects.requireNonNull(FieldPanel.class.getResource(String.format("/tanks/tank_enemy_%d.png", i))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tanks;
    }

    public void paint(Graphics g) {
        for (int y = 0; y < mapData.getHeight(); y++) {
            for (int x = 0; x < mapData.getWidth(); x++) {
                Image tile = tiles[mapData.getTile(x, y)];
                g.drawImage(tile, tileWidth * x, tileHeight * y, tileWidth, tileHeight, null);
            }
        }
        mapObjects.removeAll(markedForRemoval);
        markedForRemoval.clear();
        mapObjects.addAll(pendingObjects);
        pendingObjects.clear();
        for (var mapObject : mapObjects) {
            mapObject.paint(g);
        }
    }

    public Map getMapData() {
        return mapData;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public void addMapObject(MapObject2D object2D) {
        pendingObjects.add(Objects.requireNonNull(object2D));
    }

    public void removeMapObject(MapObject2D object2D) {
        markedForRemoval.add(object2D);
    }

    public SimpleVector2 positionToTile(SimpleVector2 position) {
        return new SimpleVector2(position.getX() / tileWidth, position.getY() / tileHeight);
    }

    public SimpleVector2 tileToPosition(int x, int y) {
        return new SimpleVector2(x * tileWidth + tileWidth / 2f, y * tileHeight + tileHeight / 2f);
    }

    public SimpleVector2 positionToMap(SimpleVector2 objectPosition) {
        return new SimpleVector2((int) objectPosition.getX() / tileWidth * tileWidth, (int) objectPosition.getY() / tileHeight * tileHeight);
    }
}
