package Game;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        super("Tanks game");
        setSize(640, 640);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new FieldPanel());
        addKeyListener(new InputHandler());
        setVisible(true);
    }

}
