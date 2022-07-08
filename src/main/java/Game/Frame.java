package Game;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private final JFrame frame;

    public Frame() {
        frame = new JFrame("Tanks Game");
        frame.setSize(640, 640);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
