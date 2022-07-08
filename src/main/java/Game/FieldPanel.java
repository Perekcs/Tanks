package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class FieldPanel extends JPanel {
    private final Map map;
    private final Image[] tiles;

    public FieldPanel() {
        super();
        tiles = new Image[14];
        setBackground(Color.BLACK);
        try {
            map = Map.fromMapFolder("test_map_1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadTiles();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // TODO: render field
        paintMap(g, map);
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
    }
}
