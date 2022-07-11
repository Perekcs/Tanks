package Game;

import javax.swing.*;

public class GameWindow extends JFrame {
    public static final boolean DEBUG = false;

    public GameWindow() {
        super("Tanks game");
        InputHandler inputHandler = new InputHandler();
        Bot bot = new Bot();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new FieldPanel(inputHandler, bot));
        addKeyListener(inputHandler);
        setResizable(false);
        pack();
        setVisible(true);
    }

}
