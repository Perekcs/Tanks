package Game;

import javax.swing.*;

public class GameWindow extends JFrame {
    public static final boolean DEBUG = false;
    Menu level = new Menu();
    public GameWindow() {
        super("Tanks game");
        InputHandler inputHandler = new InputHandler();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new FieldPanel(inputHandler,level.level));
        addKeyListener(inputHandler);
        setResizable(false);
        pack();
        setVisible(true);
    }

}
