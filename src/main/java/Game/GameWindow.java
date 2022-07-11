package Game;

import javax.swing.*;

public class GameWindow extends JFrame {
    public static final boolean DEBUG = false;
    private final InputHandler input;

    public GameWindow() {
        super("Tanks game");
        input = new InputHandler();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new Menu(this));
        addKeyListener(input);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public void load(String level) {
        setContentPane(new FieldPanel(input, level));
        pack();
        requestFocus();
    }

}
