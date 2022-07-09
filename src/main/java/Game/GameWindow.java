package Game;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        super("Tanks game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new FieldPanel());
        addKeyListener(new InputHandler());
        setResizable(false);
        pack();
        setVisible(true);
    }

}
