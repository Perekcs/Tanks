package Game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FieldPanel extends JPanel {
    private final Map map;

    public FieldPanel() {
        super();
        setBackground(Color.YELLOW);
        try {
            map = Map.fromMapFolder("test_map");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // TODO: render field
        paintMap(g, map);
    }

    private void paintMap(Graphics g, Map map) {
        int width = getWidth();
        int height = getHeight();
        int tileWidth = width / map.getWidth();
        int tileHeight = height / map.getHeight();
        for(int y = 0; y < map.getHeight(); y++) {
            for(int x = 0; x < map.getWidth(); x++) {
                Color c = switch (map.getTile(x, y)) {
                    case 0 -> Color.YELLOW;
                    case 1 -> Color.CYAN;
                    default -> Color.BLACK;
                };
                g.setColor(c);
                g.fillRect(tileWidth * x, tileHeight * y, tileWidth, tileHeight);
            }
        }
    }
}
