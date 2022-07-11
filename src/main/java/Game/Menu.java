package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private final GameWindow window;

    public Menu(GameWindow window) {
        super();
        this.window = window;
        setBackground(Color.DARK_GRAY);
        String[] levels = new String[]{
                "test_level_map_3",
                "test_level_map_4",
                "test_level_map_5"
        };

        for(int i = 0; i < levels.length; i++) {
            var button = new JButton("Level " + (i + 1));
            int finalI = i;
            button.addActionListener(e -> loadLevel(levels[finalI]));
            add(button);
        }
    }

    private void loadLevel(String level) {
        window.load(level);
    }
}
