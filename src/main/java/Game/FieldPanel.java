package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class FieldPanel extends JPanel {
    private final Map map;
    private final Image[] tiles;
    private int frame = 0;
    private static final Dimension SIZE = new Dimension(640, 640);
    private static final Color COLLIDER_COLOR = new Color(30, 255, 255, 124);
    private static final Color COLLISION_COLOR = new Color(255, 234, 5, 157);

    @Override
    public Dimension getPreferredSize() {
        return SIZE;
    }

    public FieldPanel() {
        super();
        tiles = new Image[14];
        setBackground(Color.BLACK);
        try {
            map = Map.fromMapFolder("test_map_2");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadTiles();
        Timer updateTimer = new Timer(10, e -> update());
        updateTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        System.out.printf("\ro-%b w-%d h-%d",isOptimizedDrawingEnabled(), getWidth(), getHeight());
        super.paintComponent(g);
        // TODO: render field
        paintMap(g, map);
        frame++;
    }

    private void update() {
        repaint(5);
    }

    private void loadTiles() {
        for(int i = 0; i < tiles.length; i++) {
            try {
                tiles[i] = ImageIO.read(Objects.requireNonNull(FieldPanel.class.getResource(String.format("/tiles/tile_%d.png", i))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void paintMap(Graphics g, Map map) {
        int width = getWidth();
        int height = getHeight();
        int tileWidth = width / map.getWidth();
        int tileHeight = height / map.getHeight();
        for(int y = 0; y < map.getHeight(); y++) {
            for(int x = 0; x < map.getWidth(); x++) {
                Image tile = tiles[map.getTile(x, y)];
                g.drawImage(tile, tileWidth * x, tileHeight * y, tileWidth, tileHeight, null);
            }
        }

        g.setColor(Color.DARK_GRAY);
        int posX = frame % (getWidth() - 20);
        int posY = frame % (getHeight() - 20);
        g.fillRect(posX, posY, 10, 10);
        int tileX = posX / tileWidth;
        int tileY = posY / tileHeight;
        g.setColor(map.getTile(tileX, tileY) != 0 ? COLLISION_COLOR : COLLIDER_COLOR);
        g.fillRect(tileX * tileWidth, tileY * tileHeight, tileWidth, tileHeight);
    }
}
