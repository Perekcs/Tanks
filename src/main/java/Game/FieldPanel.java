package Game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FieldPanel extends JPanel {
    private final GameMap2D gameMap;
    private static final Dimension SIZE = new Dimension(640, 640);

    @Override
    public Dimension getPreferredSize() {
        return SIZE;
    }

    public FieldPanel(InputHandler inputHandler) {
        super();
        setBackground(Color.BLACK);
        Map map;
        try {
            map = Map.fromMapFolder("test_level_map_3");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gameMap = new GameMap2D(map, SIZE.width, SIZE.height, inputHandler);
        Timer updateTimer = new Timer(10, e -> update());
        updateTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        super.paintComponent(g);
        gameMap.paint(g);
    }

    private void update() {
        repaint(5);
    }
}
