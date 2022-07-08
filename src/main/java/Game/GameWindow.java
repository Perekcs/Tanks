package Game;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        super("Tanks game");
        setSize(640, 640);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(new FieldPanel());
        addKeyListener(new InputHandler());
    }

}
